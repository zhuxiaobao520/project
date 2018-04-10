package com.cbd.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义日志注解
 * @author 吴雪
 * 2018年2月1日
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * @author 吴雪
	 * 2018年2月1日
	 * 要执行的操作类型，如添加/修改/删除/登录/注销
	 */
	public String operationType() default "";
	
	/**
	 * @author 吴雪
	 * 2018年2月1日
	 * 要执行的具体操作内容，如添加企业用户/修改个人用户密码等
	 */
	public String operationName() default "";
}
