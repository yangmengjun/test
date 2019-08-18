package com.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE,ElementType.METHOD}) //TYPE表示作用域是类或接口
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
	/**
	 * 如果只有一个成员变量，则命名必须为value
	 * 可以通过反射机制拿出注解的相关信息
	 * @return
	 */
	String value();
	
	int type();
}
