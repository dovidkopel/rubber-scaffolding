package io.wizdumb.scaffolding.random.randomizers

import io.wizdumb.scaffolding.config.{AnnotationCapable, AnnotationField, _}
import io.wizdumb.scaffolding.random.predicate.{ClassRandomGenerator, RandomContext}
import io.wizdumb.scaffolding.utils.Logging

/**
  * Created by dkopel on 12/6/16.
  */
class DoubleRandomizer extends ClassRandomGenerator[Double]
    with Configurable with AnnotationCapable with Logging {
    override def apply(rc: RandomContext): Double = {
        val min = rc.conf.conf[Double](DoubleRandomizerMinName).getValue()
        val max = rc.conf.conf[Double](DoubleRandomizerMaxName).getValue()
        logger.debug("Min {}, Max {}", min, max)

        rc.jpr.doubles.nextDouble(min, max)
    }

    object DoubleRandomizerMinName extends ConfigName("doubleRandomizerMin")
    object DoubleRandomizerMaxName extends ConfigName("doubleRandomizerMax")

    val minDef: ConfigDefinition[Double] = ConfigDefinition[Double](
        DoubleRandomizerMinName,
        Some(Double.MinValue)
    )

    val maxDef: ConfigDefinition[Double] = ConfigDefinition[Double](
        DoubleRandomizerMaxName,
        Some(Double.MaxValue)
    )

    private val defs = Seq(
        minDef,
        maxDef
    )

    override def configBundle: ConfigBundle = {
        ConfigBundle(
            getClass,
            defs.map(d => (d.name, d)).toMap
        )
    }

    override def name: String = "DoubleRange"

    override def values: Set[AnnotationField[_, _]] = Set(
        AnnotationField("min", minDef, classOf[Double], classOf[Double]),
        AnnotationField("max", maxDef, classOf[Double], classOf[Double])
    )

    override def classes: Array[Class[_]] = Array(classOf[java.lang.Double], classOf[Double])
}