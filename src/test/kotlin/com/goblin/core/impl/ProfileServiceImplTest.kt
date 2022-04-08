package com.goblin.core.impl

import com.goblin.core.Profile
import com.goblin.core.ProfileProducer
import com.goblin.core.ProfileRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@MicronautTest(rollback = false, transactional = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProfileServiceImplTest {

    @Inject
    lateinit var profileRepository: ProfileRepository

    @Inject
    lateinit var profileProducer: ProfileProducer

    @Inject
    lateinit var profileServiceImpl: ProfileServiceImpl

    @Test
    fun `getProfileById return profile data when success`() {
        // given
        val mockedProfile = Profile(
            null,
            "firstName",
            "lastName",
            "address",
            "ID",
            "east java",
            "madiun",
            "63133",
        )
        val createdProfile = profileRepository.save(mockedProfile)

        // when
        val result = this.profileServiceImpl.getProfileById(createdProfile.id!!)

        // then
        assertNotNull(result)
        assertEquals(mockedProfile, result)
    }
}
