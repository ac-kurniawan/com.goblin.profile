package com.goblin.controller

import com.goblin.controller.Dto.CreateProfileRequest
import com.goblin.controller.Dto.ProfileResponse
import com.goblin.controller.Dto.toDto
import com.goblin.core.ProfileService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.opentelemetry.api.trace.SpanKind
import io.opentelemetry.extension.annotations.SpanAttribute
import io.opentelemetry.extension.annotations.WithSpan
import java.util.UUID

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/profile")
@ExecuteOn(TaskExecutors.IO)
open class ProfileController(private val profileService: ProfileService) {
    @Get("/health")
    fun healthCheck(): HttpResponse<String> {
        return HttpResponse.ok("ok")
    }

    @Get("/{id}")
    @WithSpan
    fun getProfileById(@SpanAttribute("id") id: UUID): HttpResponse<ProfileResponse> {
        val result = this.profileService.getProfileById(id).toDto()

        return HttpResponse.ok(result)
    }

    @Post("/")
    @WithSpan(kind = SpanKind.SERVER)
    fun createProfile(@Body createProfileRequest: CreateProfileRequest): HttpResponse<ProfileResponse> {
        val result = this.profileService.createProfile(createProfileRequest.toEntity()).toDto()

        return HttpResponse.created(result)
    }
}
