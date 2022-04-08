package com.goblin.integrationTest.utils

import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
class PsqlContainer(imageName: String) : PostgreSQLContainer<Nothing>(imageName)
