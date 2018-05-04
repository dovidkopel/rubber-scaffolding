package io.wizdumb.scaffolding.messaging

import io.wizdumb.scaffolding.messaging.response.Response

/**
  * Created by dkopel on 9/27/16.
  */
case class Replies (responses: Seq[Response[_]])
case class Reply (replies: Replies, reply: Response[_])