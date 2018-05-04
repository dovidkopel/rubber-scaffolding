package io.wizdumb.scaffolding.random.randomizers

import io.wizdumb.scaffolding.config.{AnnotationCapable, AnnotationField, _}
import io.wizdumb.scaffolding.random.predicate.{ClassRandomGenerator, RandomContext}
import io.wizdumb.scaffolding.utils.Logging

/**
  * Created by dkopel on 12/6/16.
  */
class FloatRandomizer extends ClassRandomGenerator[Float]
    with Configurable with AnnotationCapable with Logging {
    override def apply(rc: RandomContext): Float = {
        val min = rc.conf.conf[Float](FloatRandomizerMinName).getValue()
        val max = rc.conf.conf[Float](FloatRandomizerMaxName).getValue()
        logger.debug("Min {}, Max {}", min, max)

        rc.jpr.floats.nextFloat(min, max)
    }

    object FloatRandomizerMinName extends ConfigName("floatRandomizerMin")
    object FloatRandomizerMaxName extends ConfigName("floatRandomizerMax")

    val minDef: ConfigDefinition[Float] = ConfigDefinition[Float](
        FloatRandomizerMinName,
        Some(Float.MinValue)
    )

    val maxDef: ConfigDefinition[Float] = ConfigDefinition[Float](
        FloatRandomizerMaxName,
        Some(Float.MaxValue)
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

    override def name: String = "FloatRange"

    override def values: Set[AnnotationField[_, _]] = Set(
        AnnotationField("min", minDef, classOf[Float], classOf[Float]),
        AnnotationField("max", maxDef, classOf[Float], classOf[Float])
    )

    override def classes: Array[Class[_]] = Array(classOf[java.lang.Float], classOf[Float])
}