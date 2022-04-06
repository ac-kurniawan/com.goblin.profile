package com.goblin.core.impl

import com.goblin.core.Profile
import com.goblin.core.ProfileProducer
import com.goblin.core.ProfileRepository
import com.goblin.core.ProfileService
import com.goblin.utils.MessagePayload
import io.opentelemetry.api.trace.SpanKind
import io.opentelemetry.extension.annotations.WithSpan
import jakarta.inject.Singleton
import java.util.*

@Singleton
class ProfileServiceImpl(
    private val profileRepository: ProfileRepository,
    private val profileProducer: ProfileProducer
) : ProfileService{
    @WithSpan
    override fun createProfile(data: Profile): Profile {
        val result = this.profileRepository.save(data)

        this.profileProducer.profileCreated(result.id.toString(), MessagePayload("profile_created", result))
        return result
    }

    @WithSpan
    override fun getProfileById(id: UUID): Profile {
        val result = this.profileRepository.findById(id)?: throw Exception("Not found")
        return result
    }

    @WithSpan
    override fun deleteProfileById(id: UUID) = this.profileRepository.deleteById(id)

    @WithSpan
    override fun manageProfileCreated(data: Profile) {
        data.id?.let { this.deleteProfileById(it) }
    }
}