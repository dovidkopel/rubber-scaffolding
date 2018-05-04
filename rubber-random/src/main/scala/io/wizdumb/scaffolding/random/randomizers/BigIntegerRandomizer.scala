package io.wizdumb.scaffolding.random.randomizers

import io.wizdumb.scaffolding.config._
import io.wizdumb.scaffolding.random.predicate.RandomContext

/**
  * Created by dkopel on 12/12/16.
  */
class BigIntegerRandomizer extends (RandomContext=>java.lang.Number) with Configurable {
    override def apply(rc: RandomContext): java.lang.Number = {
        val bits = rc.conf.conf[Integer](BigIntegerBitsName).getValue()
        val bi = new java.math.BigInteger(bits, rc.jpr.random)

        if(rc.tc.clazz.equals(classOf[java.math.BigInteger])) bi
        else BigInt(bi)
    }

    object BigIntegerBitsName extends ConfigName("bigIntegerBits")

    val biBitsDef = ConfigDefinition[Integer](
        BigIntegerBitsName,
        Some(128)
    )

    override def configBundle: ConfigBundle = ConfigBundle(
        getClass,
        Seq(biBitsDef)
    )
}