package io.wizdumb.scaffolding.transformer.graph.rules

import java.lang.reflect.Field

import io.wizdumb.scaffolding._
import io.wizdumb.scaffolding.utils.ReflectionUtils
import org.slf4j.LoggerFactory

import scala.reflect.runtime.universe.Type

/**
  * Created by dkopel on 11/2/16.
  */
case class FieldRuleTarget[T, U](tpe: Type, field: Field) extends RuleTarget[T, U] {
    private val logger = LoggerFactory.getLogger(getClass)
    val propertyName = field.getName

    override def set[Z >: U](inst: T, fieldValue: Z): T = {
        logger.debug("Setting field `{}` to value {}", field.getName, fieldValue)
        ReflectionUtils.setField(field, inst, fieldValue)
        inst
    }

    override def get(inst: T): U = ReflectionUtils.getFieldValue(field, inst)
}

object FieldRuleTarget {
    def apply[T, U](clazz: Class[T], property: String): FieldRuleTarget[T, U] = {
        new FieldRuleTarget[T, U](clazz, ReflectionUtils.getDeepProperty(clazz, property))
    }
}