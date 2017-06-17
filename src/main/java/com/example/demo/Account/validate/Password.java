package com.example.demo.Account.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Password {
    String message() default "password format wrong";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
