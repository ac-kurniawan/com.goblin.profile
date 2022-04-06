package com.goblin.core

import java.util.*

interface ProfileService {
    fun createProfile(data: Profile): Profile
    fun getProfileById(id: UUID): Profile
    fun deleteProfileById(id: UUID): Int
    fun manageProfileCreated(data: Profile)
}