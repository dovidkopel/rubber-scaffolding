package io.wizdumb.scaffolding.messaging.config

import java.time.Duration

import io.wizdumb.scaffolding.messaging.Replies
import io.wizdumb.scaffolding.messaging.response.Response

/**
  * Created by dkopel on 9/8/16.
  */
case class MaxDurationResponse(
                                                                        override val _handler: Function[Replies, Response[_]],
                                                                        private val maxDuration: Duration
                                                            ) extends ResponseConfigurationBuilder(true, _handler, (t) => t.getElapsed >= maxDuration.toMillis)
