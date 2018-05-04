package io.wizdumb.scaffolding.transformer.support;

/**
 * Created by dkopel on 11/22/16.
 */
public @interface Limitation {
    Class<? extends io.wizdumb.scaffolding.transformer.limitation.Limitation> value() default io.wizdumb.scaffolding.transformer.limitation.Limitation.class;
    String[] args() default {};
    Class[] classes() default {};
}