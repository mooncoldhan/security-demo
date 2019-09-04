package com.imooc.validatior;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Title: MyConstraintValidatior
 * @ProjectName imooc-security
 * @Description: TODO
 * @author Administrator
 * @date 2019/9/414:04
 */
                                                //ConstraintValidator泛型=第一个值表示指明哪个注解
                                                // 第二个表示修饰的类型是什么
public class MyConstraintValidatior implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    //校验器初始化
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("initialize is run");
    }

    //校验逻辑
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println(value);
        helloService.greeting("xiaowei");
        return false;
    }
}
