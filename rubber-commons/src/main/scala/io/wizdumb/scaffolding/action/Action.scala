package io.wizdumb.scaffolding.action


import io.wizdumb.scaffolding.messaging.Message
import io.wizdumb.scaffolding.messaging.config.ResponseConfiguration

/**
  * Created by dkopel on 8/23/16.
  */
trait Action extends Serializable {
    val configurations: Map[EventLifecycle, ResponseConfiguration]

    def getConfiguration(event: EventLifecycle): Option[ResponseConfiguration] = configurations.get(event)

    val triggers: List[Trigger[_]]

    def message: Message[_]
}