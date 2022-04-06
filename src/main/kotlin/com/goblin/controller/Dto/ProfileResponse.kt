package com.goblin.controller.Dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.goblin.core.Profile
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

data class ProfileResponse(
    @field:JsonProperty("id", required = true)
    var id: UUID? = null,

    @field:JsonProperty("firstName", required = true)
    val firstName: String,

    @field:JsonProperty("lastName", required = true)
    val lastName: String,

    @field:JsonProperty("address", required = true)
    val address: String,

    @field:JsonProperty("country", required = true)
    val country: String,

    @field:JsonProperty("province", required = true)
    val province: String,

    @field:JsonProperty("city", required = true)
    val city: String,

    @field:JsonProperty("zipcode", required = true)
    val zipcode: String,

    @field:JsonProperty("createdAt", required = true)
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    var createdAt: LocalDateTime,

    @field:JsonProperty("updatedAt")
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    var updatedAt: LocalDateTime? = null,

    @field:JsonProperty("deletedAt")
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    var deletedAt: LocalDateTime? = null,
    )

fun Profile.toDto() = ProfileResponse(
    id, firstName, lastName, address, country, province, city,zipcode, createdAt = LocalDateTime.ofInstant(createdAt, ZoneOffset.UTC), updatedAt = LocalDateTime.ofInstant(updatedAt, ZoneOffset.UTC), deletedAt
)