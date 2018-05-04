package io.wizdumb.scaffolding.transformer.support;

import io.wizdumb.scaffolding.transformer.function.FunctionTransformation;

import java.lang.annotation.*;

/**
 * Created by dkopel on 9/27/16.
 */

/**
 * boolean emptyString() - When set to `true` the value will be an empty string ""
 * boolean isNull() - When set to `true` the value will be NULL
 * String value() - Uses the value of the SpEL expression as the value
 */
@Repeatable(io.wizdumb.scaffolding.transformer.support.Transformations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Transformation {
    long order() default 0L;
    boolean emptyString() default false;
    boolean isNull() default false;
    String value() default "";
    io.wizdumb.scaffolding.transformer.support.FunctionTransformation function() default @io.wizdumb.scaffolding.transformer.support.FunctionTransformation(key="", clazz=FunctionTransformation.class);
    String condition() default "";
    io.wizdumb.scaffolding.transformer.support.Limitation[] limits() default {};
}
