package com.zh.anno;

import com.zh.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {StateValidation.class})
@Target({FIELD})
@Retention(RUNTIME)

public @interface State {

    String message() default "the result of the state is 已完成或者草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
