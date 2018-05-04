package io.wizdumb.scaffolding.random.types

import io.wizdumb.scaffolding.config.Configuration
import io.wizdumb.scaffolding.random.core.{RubberRandom}

/**
  * Created by dkopel on 12/13/16.
  */
trait TypeProcessor {
    def eval[T](typeContainer: TypeContainer[T])(implicit rubberRandom: RubberRandom, conf: Configuration): Boolean
    def apply[T](typeContainer: TypeContainer[T])(implicit rubberRandom: RubberRandom, conf: Configuration): T
}
