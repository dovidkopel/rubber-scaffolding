package io.wizdumb.scaffolding.random.support.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import io.wizdumb.scaffolding.random.support.annotations.RandomConfigAnnotation;
/** Auto-generated **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@RandomConfigAnnotation(value=io.wizdumb.scaffolding.random.randomizers.DoubleRandomizer.class)
public @interface DoubleRange {
	double min() default 0D;
	double max() default 0D;
}