package io.wizdumb.scaffolding.random.types
import io.wizdumb.scaffolding.config.Configuration
import io.wizdumb.scaffolding.random.core.RubberRandom
import io.wizdumb.scaffolding.utils.TypeUtils

/**
  * Created by dkopel on 12/13/16.
  */
object ArrayTypeProcessor extends TypeProcessor {
    override def apply[T](typeContainer: TypeContainer[T])(implicit rubberRandom: RubberRandom, conf: Configuration=Configuration.empty): T = {
        TypeUtils.convertToArray(
            rubberRandom.generateCount[T, T](
                typeContainer,
                tc => {
                    val g = TypeContainer(tc.clazz.getComponentType, Option(tc))
                    rubberRandom.generateTypeContainer(g)
                }
            )(conf).toList, typeContainer.clazz).asInstanceOf[T]
    }

    override def eval[T](typeContainer: TypeContainer[T])(
        implicit rubberRandom: RubberRandom,
        conf: Configuration=Configuration.empty
    ): Boolean = typeContainer.clazz.isArray
}