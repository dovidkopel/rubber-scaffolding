package io.wizdumb.scaffolding.random.predicate

import io.wizdumb.scaffolding.config.Configuration
import io.wizdumb.scaffolding.random.JavaPrimitiveRandomizer
import io.wizdumb.scaffolding.random.core.JavaPrimitives
import io.wizdumb.scaffolding.random.types.TypeContainer

/**
  * Created by dkopel on 11/30/16.
  */
class RandomContext(val tc: TypeContainer[_])
                   (implicit val conf: Configuration, javaPrimitives: JavaPrimitives) {
    val parent: Option[TypeContainer[_]] = tc.ptc
    val jpr: JavaPrimitiveRandomizer = javaPrimitives.jpr
}
object RandomContext {
    implicit def apply(tc: TypeContainer[_])
                      (implicit conf: Configuration, javaPrimitives: JavaPrimitives): RandomContext = {
        new RandomContext(tc)(conf, javaPrimitives)
    }
}