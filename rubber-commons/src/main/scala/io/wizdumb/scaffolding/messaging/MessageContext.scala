package io.wizdumb.scaffolding.messaging

import io.wizdumb.scaffolding.messaging.config.ResponseConfiguration
import io.wizdumb.scaffolding.messaging.response.Response

/**
  * Created by dkopel on 8/22/16.
  */
trait MessageContext {
    val message: Message[_]
    val configuration: ResponseConfiguration

    def getStartedAt: Long

    def getElapsed: Long

    def getSubscribedCount: Long

    def getRepliedCount: Long

    def getAccumulator: () => List[Response[_]]

    def getResponses: List[Response[_]]
}