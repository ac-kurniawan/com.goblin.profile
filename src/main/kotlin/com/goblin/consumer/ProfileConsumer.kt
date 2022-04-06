package com.goblin.consumer

import com.goblin.consumer.Dto.MessagePayloadProfile
import com.goblin.core.ProfileService
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.MessageBody
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.opentelemetry.api.trace.SpanKind
import io.opentelemetry.extension.annotations.WithSpan

@KafkaListener(offsetReset = OffsetReset.EARLIEST, groupId = "com.goblin.profile")
@ExecuteOn(TaskExecutors.IO)
class ProfileConsumer(private val profileService: ProfileService) {
    @Topic("com.goblin.profile")
    @WithSpan(kind = SpanKind.CONSUMER)
    fun manageTopicProfile(@KafkaKey id: String, @MessageBody message: MessagePayloadProfile) {

        if (message.eventType == "profile_created") {
            this.profileService.manageProfileCreated(message.payload)
        }
    }
}