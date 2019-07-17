package com.yqkj.utile;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 
  * 
  * @ClassName: BeanTool
  * @Description: 
  * @author yangchao.coo@gmail.com
  * @date 2019年5月22日 上午11:16:52
  *
 */
public class BeanTool {
	
	public static String SPIT_FLAG = "_";

	/**
	 * 
	  * 
	  * @Description: 
	  * @param source
	  * @param target void
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年5月22日 上午9:15:09
	 */
	public static <R , O> void copyObject(R source , O target) {
		if (Objects.isNull(source)) {
			return ;
		}
		copyObject(source, target, null, (String[]) null);
	}
	/**
	  * 解决数据问题导致整个页面数据崩溃
	  * 
	  * @Description: 
	  * @param source
	  * @param target
	  * @param editable
	  * @param ignoreProperties void
	  * @exception:
	  * @throws
	  * @author: yangchao.coo@gmail.com
	  * @time:2019年5月22日 上午9:13:16
	 */
	public static <R , O> void copyObject(R source , O target, Class<?> editable, String... ignoreProperties) {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass();
		if (editable != null) {
			if (!editable.isInstance(target)) {
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
						"] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
		List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

		for (PropertyDescriptor targetPd : targetPds) {
			Method writeMethod = targetPd.getWriteMethod();
			if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
				PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null) {
					Method readMethod = sourcePd.getReadMethod();
					if (readMethod != null &&
							ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
						try {
							if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
						catch (Throwable ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		}
	}

}
