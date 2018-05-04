package io.wizdumb.scaffolding.messaging

import java.util.UUID

import io.wizdumb.scaffolding.action.PredicateTrigger

import scala.beans.BeanProperty

/**
  * Created by dkopel on 8/31/16.
  */
case class Subscription[T <: java.io.Serializable](
                                                            id: UUID = UUID.randomUUID(),
                                                            @BeanProperty predicate: (Message[T])=>Boolean,
                                                            override val handlers: Seq[MessageHandler])
    extends PredicateTrigger[Message[T]] {
    def canEqual(other: Any): Boolean = other.isInstanceOf[Subscription[T]]

    override def equals(other: Any): Boolean = other match {
        case that: Subscription[T] =>
            (that canEqual this) &&
                id == that.id &&
                handlers == that.handlers
        case _ => false
    }

    override def hashCode(): Int = {
        val state = Seq(id, handlers)
        state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
    }

    override def test(implicit t: Message[T]): Boolean = predicate.apply(t)
}