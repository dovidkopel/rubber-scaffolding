package io.wizdumb.scaffolding.knowledge.rule.support.annotations;

import io.wizdumb.scaffolding.knowledge.rule.Criteria;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dkopel on 10/11/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Opposite {
    Class<? extends Criteria> value();
}
