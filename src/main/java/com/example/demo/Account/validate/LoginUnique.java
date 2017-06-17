package com.example.demo.Account.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = LoginUniqueValidator.class)
public @interface LoginUnique {
    String message() default "Your registered login name has exist";
    Class<?>[] groups()default {};
    Class<? extends Payload>[] payload() default {};
}
