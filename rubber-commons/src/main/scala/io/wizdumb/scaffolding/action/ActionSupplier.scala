package io.wizdumb.scaffolding.action

import io.wizdumb.scaffolding.messaging.response.Response


/**
  * Created by dkopel on 8/25/16.
  */
trait ActionSupplier[R <: Serializable] extends Action with (() => R) {
    var response: Response[R]
}