package integrationTest.com.goblin.core.impl

import integrationTest.utils.PsqlContainer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.Test
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.testcontainers.junit.jupiter.Testcontainers

@MicronautTest
@Testcontainers
class ProfileServiceImplTest {
    private val psqlContainers = PsqlContainer("postgres:12-alpine").apply {
        withDatabaseName("postgres")
        withInitScript("migrations/V1__create-schema.sql")
    }

    @BeforeAll
    fun beforeAll() {
        this.psqlContainers.start()
    }

    @AfterAll
    fun afterAll() {
        this.psqlContainers.stop()
    }

    @Test
    fun `container is up and running`() {
        Assertions.assertTrue(this.psqlContainers.isRunning)
    }
}
