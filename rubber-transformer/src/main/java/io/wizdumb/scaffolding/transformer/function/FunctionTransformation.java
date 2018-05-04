package io.wizdumb.scaffolding.transformer.function;

import io.wizdumb.scaffolding.transformer.service.TransformationContext;

/**
 * Created by dkopel on 11/17/16.
 */
public interface FunctionTransformation<V> {
    V next(TransformationContext context);
}