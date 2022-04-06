package com.goblin.core

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.Version

@Entity
@Table(name = "profile")
data class Profile(
    @Id
    @GeneratedValue(generator = "UUID")
    var id: UUID? = null,

    @Column(name = "first_name", nullable = false)
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    val lastName: String,

    @Column(name = "address", nullable = false)
    val address: String,

    @Column(name = "country", nullable = false)
    val country: String,

    @Column(name = "province", nullable = false)
    val province: String,

    @Column(name = "city", nullable = false)
    val city: String,

    @Column(name = "zipcode", nullable = false)
    val zipcode: String,

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    var createdAt: Instant? = null,

    @Column(name = "updated_at")
    @UpdateTimestamp
    var updatedAt: Instant? = null,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null,

    @Version
    @Column(name = "version", nullable = false)
    var version: Long? = 0L,
) {
    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , firstName = $firstName , lastName = $lastName , address = $address , country = $country , province = $province , city = $city , zipcode = $zipcode , createdAt = $createdAt , updatedAt = $updatedAt , deletedAt = $deletedAt , version = $version )"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Profile

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}
