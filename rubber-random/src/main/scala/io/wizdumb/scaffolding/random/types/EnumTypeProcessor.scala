package io.wizdumb.scaffolding.random.types
import io.wizdumb.scaffolding.config.Configuration
import io.wizdumb.scaffolding.random.core.{RubberRandom}

/**
  * Created by dkopel on 12/13/16.
  */
object EnumTypeProcessor extends TypeProcessor {
    override def apply[T](typeContainer: TypeContainer[T])
                         (implicit rubberRandom: RubberRandom, conf: Configuration): T = {
        val inst = Class.forName(typeContainer.clazz.getName)
        val csts = inst.getEnumConstants
        val ln = csts.length
        csts(rubberRandom.jpr.ints.nextInt(0, ln-1)).asInstanceOf[T]
    }

    override def eval[T](typeContainer: TypeContainer[T])(
        implicit rubberRandom: RubberRandom,
        conf: Configuration
    ): Boolean = typeContainer.clazz.isEnum
}
