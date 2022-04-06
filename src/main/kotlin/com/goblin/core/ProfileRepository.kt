package com.goblin.core

import com.goblin.utils.KotlinCrudRepository
import java.util.UUID

interface ProfileRepository : KotlinCrudRepository<Profile, UUID>
