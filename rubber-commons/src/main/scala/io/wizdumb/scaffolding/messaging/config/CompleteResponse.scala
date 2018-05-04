package io.wizdumb.scaffolding.messaging.config

import io.wizdumb.scaffolding.messaging.Replies
import io.wizdumb.scaffolding.messaging.response.Response

/**
  * Created by dkopel on 9/8/16.
  */
case class CompleteResponse(override val _handler: Function[Replies, Response[_]]
                                                         ) extends ResponseConfigurationBuilder(true, _handler,
    t => t.getRepliedCount.equals(t.getSubscribedCount))
