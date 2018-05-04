package io.wizdumb.scaffolding.transformer.join

import io.wizdumb.scaffolding.context.ContextProvider


/**
  * Created by dkopel on 12/29/16.
  */
case class JoinsImpl(joins: Set[JoinImpl], condition: String)(implicit context: ContextProvider) {
    def isTrue: Boolean = context.evaluateCondition(condition)
}
object JoinsImpl {
    def empty: JoinsImpl = JoinsImpl(Set.empty, null)(ContextProvider.empty)

    implicit def apply(joins: io.wizdumb.scaffolding.transformer.support.Joins)(implicit context: ContextProvider): JoinsImpl = {
        JoinsImpl(joins.value().toSet[io.wizdumb.scaffolding.transformer.support.Join], joins.condition())
    }

    implicit def toJoins(j: JoinsImpl): Set[JoinImpl] = if (j.isTrue) j.joins else Set.empty[JoinImpl]
}