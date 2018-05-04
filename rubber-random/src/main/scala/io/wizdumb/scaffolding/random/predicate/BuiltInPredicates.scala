package io.wizdumb.scaffolding.random.predicate

import io.wizdumb.scaffolding.config.Configuration
import io.wizdumb.scaffolding.random.randomizers._
import io.wizdumb.scaffolding.utils.Logging

/**
  * Created by dkopel on 12/6/16.
  */
object BuiltInPredicates extends Logging {
    def predicates(implicit conf: Configuration): Set[RandomPredicate[_]] = {
        // Scala class random predicates
        ClassRandomGenerator.findClassRandomPredicates ++
        // Java class random predicates
        ClassRandomGenerator.findJavaClassRandomPredicates ++
        // Explicitly defined randomizers
        Set[RandomPredicate[_]](
            ClassRandomPredicate(
                (rc: RandomContext) => rc.jpr.ints.nextInt(),
                classOf[java.lang.Integer],
                classOf[Int],
                classOf[Integer]
            ),
            ClassRandomPredicate(
                new BigIntegerRandomizer,
                classOf[java.math.BigInteger],
                classOf[BigInt]
            ),
            ClassRandomPredicate(
                new BigDecimalRandomizer,
                classOf[java.math.BigDecimal],
                classOf[scala.math.BigDecimal]
            ),
            ClassRandomPredicate(
                (rc: RandomContext) => rc.jpr.booleans.nextBoolean(),
                classOf[java.lang.Boolean],
                classOf[Boolean]
            ),
            ClassRandomPredicate(
                (rc: RandomContext) => rc.jpr.chars.nextAlphaNumeric(),
                classOf[java.lang.Character],
                classOf[Char]
            ),
            ClassRandomPredicate(
                (rc: RandomContext) => rc.jpr.strings.nextString(),
                classOf[java.lang.String],
                classOf[String]
            ),
            ClassRandomPredicate(
                () => java.util.UUID.randomUUID(),
                classOf[java.util.UUID]
            )
        )
    }
}
