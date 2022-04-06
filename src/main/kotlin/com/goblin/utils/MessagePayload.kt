package com.goblin.utils

import com.fasterxml.jackson.annotation.JsonProperty

data class MessagePayload<T>(
    @field:JsonProperty("eventType", required = true)
    val eventType: String,

    @field:JsonProperty("payload")
    var payload: T
)
