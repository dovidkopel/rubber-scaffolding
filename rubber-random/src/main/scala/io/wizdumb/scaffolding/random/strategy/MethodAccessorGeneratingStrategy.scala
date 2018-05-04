package io.wizdumb.scaffolding.random.strategy

import io.wizdumb.scaffolding.config.Configuration
import io.wizdumb.scaffolding.random.Parameter
import io.wizdumb.scaffolding.random.types.TypeContainer

/**
  * Created by dkopel on 12/8/16.
  */
object MethodAccessorGeneratingStrategy extends GeneratingStrategy {
    override def apply[T](typeContainer: TypeContainer[T], args: Seq[Parameter[_]])
                         (implicit conf: Configuration): T = ???
}
