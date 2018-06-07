package wsz.spring.jpa.utils;
/**
 * 自定义注释信息注解
 * @author wsz
 * 2018年6月6日 上午9:31:21
 */
public @interface Des {

	String value() default "";
	
}
