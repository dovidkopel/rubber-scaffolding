package io.wizdumb.scaffolding.knowledge.dependency.sequential

/**
  * Created by dkopel on 9/21/16.
  */
trait SequentialDataProvider[T] {
    def next: T
}
