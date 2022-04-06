package com.goblin.core

import com.goblin.utils.MessagePayload
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody
import io.opentelemetry.api.trace.SpanKind
import io.opentelemetry.extension.annotations.WithSpan

@KafkaClient
interface ProfileProducer {
    @Topic("com.goblin.profile")
    @WithSpan(kind = SpanKind.PRODUCER)
    fun profileCreated(@KafkaKey key: String, @MessageBody data: MessagePayload<Profile>)
}
