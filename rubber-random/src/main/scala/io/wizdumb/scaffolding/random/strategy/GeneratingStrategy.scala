package io.wizdumb.scaffolding.random.strategy

import io.wizdumb.scaffolding.config._
import io.wizdumb.scaffolding.random.Parameter
import io.wizdumb.scaffolding.random.types.TypeContainer
import io.wizdumb.scaffolding.utils.Logging

/**
  * Created by dkopel on 12/6/16.
  */
trait GeneratingStrategy extends Logging {
    def apply[T](typeContainer: TypeContainer[T], args: Seq[Parameter[_]])(implicit conf: Configuration): T
}
object GeneratingStrategy extends Configurable {
    object GeneratingStrategyName extends ConfigName("generatingStrategy")

    val generatingStrategyDef = ConfigDefinition[Class[_ <: GeneratingStrategy]](
        GeneratingStrategyName,
        Some(classOf[FieldGeneratingStrategy])
    )

    override def configBundle: ConfigBundle = ConfigBundle(
        getClass,
        Seq(generatingStrategyDef)
    )
}