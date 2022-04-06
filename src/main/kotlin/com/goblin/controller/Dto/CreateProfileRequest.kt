package com.goblin.controller.Dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.goblin.core.Profile

data class CreateProfileRequest(
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
) {
    fun toEntity(): Profile {
        return Profile(
            firstName = firstName,
            lastName = lastName,
            address = address,
            country = country,
            province = province,
            city = city,
            zipcode = zipcode
        )
    }
}
