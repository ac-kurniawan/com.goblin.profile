package com.goblin.consumer.Dto

import com.goblin.core.Profile

data class MessagePayloadProfile(
    val eventType: String,
    val payload: Profile
)
