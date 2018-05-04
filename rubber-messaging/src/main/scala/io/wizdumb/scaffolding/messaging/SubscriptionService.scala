package io.wizdumb.scaffolding.messaging

import java.util.UUID

import io.wizdumb.scaffolding.messaging.config.ResponseConfiguration

import scala.concurrent.Future

/**
 * Created by dkopel on 9/1/16.
 */
trait SubscriptionService {
    def subscribe[T <: java.io.Serializable](subscription: Subscription[T]): UUID
    def unsubscribe(id: UUID)
    def broadcast[T <: java.io.Serializable](message: Message[T], conf: Option[ResponseConfiguration]=None): Future[Replies]
}
