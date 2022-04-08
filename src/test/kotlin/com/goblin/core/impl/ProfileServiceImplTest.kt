package com.goblin.core.impl

import com.goblin.core.ProfileProducer
import com.goblin.core.ProfileRepository
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito

@MicronautTest
open class ProfileServiceImplTest {

    val mockProfileRepository: ProfileRepository = Mockito.mock(ProfileRepository::class.java)
    val mockProducer: ProfileProducer = Mockito.mock(ProfileProducer::class.java)

    lateinit var profileServiceImpl: ProfileServiceImpl

    @BeforeEach
    fun setUp() {
        profileServiceImpl = ProfileServiceImpl(mockProfileRepository, mockProducer)
    }
}
