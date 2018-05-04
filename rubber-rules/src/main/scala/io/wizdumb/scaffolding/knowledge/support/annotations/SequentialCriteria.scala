package io.wizdumb.scaffolding.knowledge.support.annotations

import java.lang.annotation.{Retention, RetentionPolicy}

import io.wizdumb.scaffolding.operators.SequentialOperator

import scala.annotation.StaticAnnotation

/**
  * Created by dkopel on 01/06/16.
  */
@Retention(RetentionPolicy.RUNTIME)
trait SequentialCriteria extends StaticAnnotation{
    def operator: SequentialOperator

    def oppositeCriteria: Class[_ <: SequentialCriteria]
}