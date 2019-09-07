package com.imooc.validatior;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 * @Title: MyConstraint
 * @ProjectName imooc-security
 * @Description: TODO
 * @date 2019/9/413:53
 */
@Target({ElementType.METHOD,ElementType.TYPE}) //表示该注解可用于方法或类上
@Retention(RetentionPolicy.RUNTIME) //表明该注解是运行时注解
@Constraint(validatedBy = MyConstraintValidatior.class)  //表示当前注解需要用哪个类来表示
public @interface MyConstraint {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
