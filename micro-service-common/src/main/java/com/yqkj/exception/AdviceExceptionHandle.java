package com.yqkj.exception;


import com.yqkj.utile.ResponseToole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
  * class_name: GlobalExceptionHandle
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 下午11:16
  *
 **/

@ControllerAdvice
@Slf4j
public class AdviceExceptionHandle {

    /**
     * 參數異常處理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({ParamException.class})
    public Object handleParamException(ParamException e) {
       return  new Object();
    }
    /**
     * 業務異常處理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({BizException.class})
    public Object handleBizException(BizException e) {
        return  new Object();
    }

    /**
     * 業務異常處理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({InvalidGrantException.class})
    public Object handleInvalidGrantException(InvalidGrantException e) {
        return  ResponseToole.error(402 ,"用戶或密碼有誤");
    }

    @ResponseBody
    @ExceptionHandler({AccessDeniedException.class})
    public Object handleAccessDeniedHandlerException(AccessDeniedException e) {
        return  ResponseToole.error(408 ,"用戶或密碼有誤");
    }

    @ResponseBody
    @ExceptionHandler({Throwable.class})
    public Object handleThrowable(Throwable e) {

        log.info("handleThrowable:{}" ,e);
        if (e instanceof ParamException){
            return  this.handleParamException((ParamException)e);
        }else if (e instanceof BizException){
            return  this.handleBizException((BizException)e);
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException =(MethodArgumentNotValidException)e;
            return  ResponseToole.error( 501,methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
        }

        return  ResponseToole.error(500 ,"處理失敗");
    }

}
