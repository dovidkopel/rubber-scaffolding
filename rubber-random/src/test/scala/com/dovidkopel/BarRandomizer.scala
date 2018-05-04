package com.dovidkopel

import io.wizdumb.scaffolding.random.Bar
import io.wizdumb.scaffolding.random.predicate.{ClassRandomGenerator, RandomContext}

/**
  * Created by dkopel on 1/26/17.
  */
class BarRandomizer extends ClassRandomGenerator[Bar] {
    override def apply(v1: RandomContext): Bar = new Bar("this is bar")

    override def classes: Array[Class[_]] = Array(classOf[Bar])
}