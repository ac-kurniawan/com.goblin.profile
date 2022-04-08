package com.goblin
import com.goblin.utils.PostgresContainer
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@MicronautTest
class ProfileTest {
    companion object {
        val psqlContainer = PostgresContainer("postgres:12-alpine").apply {
            withDatabaseName("postgres")
            withUsername("username")
            withPassword("password")
            withInitScript("migrations/V1__create-schema.sql")
        }
    }
    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun testItWorks() {
        psqlContainer.start()
        Assertions.assertTrue(application.isRunning)
    }
}
