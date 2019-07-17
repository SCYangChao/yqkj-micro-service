package com.yqkj.log;

import com.alibaba.fastjson.JSONObject;
import com.yqkj.dto.LogDto;
import com.yqkj.utile.IpUtile;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


/**
 *
  * class_name: ControllerAop
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午6:25
  *
 **/

@Slf4j
@Aspect
@Component
public class LogAop {


    @Autowired(required = false)
    private ILogPersistentService  logPersistentService;

    @Pointcut("execution(public com.yqkj.dto.Response *(..))")
    public void LogAop() {
    }
    /**
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("LogAop()")
    private Object methodHandler(ProceedingJoinPoint pjp) throws  Throwable {
        long startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        String ip = null ,method = null,param = JSONObject.toJSONString(pjp.getArgs());
        if (null != attributes ) {

            HttpServletRequest request = attributes.getRequest();
            ip = IpUtile.getIpAddr(request);
            method = request.getMethod();
            log.info("URL : " + request.getRequestURL().toString());
            log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
            log.info("ARGS : " + Arrays.toString(pjp.getArgs()));
        }

        Object result;
        Long coustTime = 0L;
        Integer httpStatus = 200;
        String exception = "";
        WriteLog writeLog = (WriteLog) pjp.getSignature().getDeclaringType().getAnnotation(WriteLog.class);
        try {
            result = pjp.proceed();
            coustTime = System.currentTimeMillis() - startTime;
            log.info(pjp.getSignature() + "use time:" + coustTime);
        } catch (Throwable e) {
            httpStatus = 500;
            exception = e.getMessage();
            throw  e;

        } finally {
            //日誌寫入
            LogDto logDto = new LogDto();
            logDto.setLogTime(new Date());

            logDto.setCostTime(coustTime.intValue());
            logDto.setException(exception);
            logDto.setMethod(method);
            logDto.setParams(param);
            logDto.setIp(ip);
            logDto.setResultStatus(httpStatus);

            if(!Objects.isNull(writeLog)) {
              logDto.setModel(writeLog.model());
              logDto.setTitle(writeLog.tile());
            }
            writeLog(logDto);
        }

        return result;

    }

    /**
     * @param logDto
     */
    private  void writeLog(LogDto logDto) {


        if (null != this.logPersistentService) {
            try {

                this.logPersistentService.excute(logDto);

            }catch (Exception e) {

                log.error("writeLog:{};error" ,e);

            }
        }


    }
}
