package com.goblin.utils

import org.testcontainers.containers.PostgreSQLContainer

class PostgresContainer(imageName: String) : PostgreSQLContainer<Nothing>(imageName)
