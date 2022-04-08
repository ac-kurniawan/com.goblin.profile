package com.goblin.core.impl

import com.goblin.core.Profile
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.UUID

@MicronautTest
class GetProfileByIdTest : ProfileServiceImplTest() {
    @Test
    fun `getProfileById return profile data when success`() {
        // given
        val mockedUUID = UUID.randomUUID()
        val mockedProfile = Profile(
            mockedUUID,
            "firstName",
            "lastName",
            "address",
            "ID",
            "east java",
            "madiun",
            "63133",
        )

        Mockito.`when`(this.mockProfileRepository.findById(mockedUUID)).thenReturn(mockedProfile)

        // when
        val result = this.profileServiceImpl.getProfileById(mockedUUID)

        // then
        Mockito.verify(this.mockProfileRepository).findById(mockedUUID)
        Assertions.assertEquals(mockedProfile, result)
    }
}
