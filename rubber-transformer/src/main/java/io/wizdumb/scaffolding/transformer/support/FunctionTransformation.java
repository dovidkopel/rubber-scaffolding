package io.wizdumb.scaffolding.transformer.support;

/**
 * Created by dkopel on 11/18/16.
 */
public @interface FunctionTransformation {
    String key();
    Class<? extends io.wizdumb.scaffolding.transformer.function.FunctionTransformation> clazz();
}
