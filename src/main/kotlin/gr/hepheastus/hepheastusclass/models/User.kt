package gr.hepheastus.hepheastusclass.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User {
    @Id
    @Column(name = "username", nullable = false)
    var username : String? = null

    @Column(name = "firstname", nullable = false)
    var firstName : String? = null

    @Column(name = "lastname", nullable = false)
    var lastName : String? = null

    @Column(name = "password", nullable = false)
    var password : String? = null

    @Column(name = "roles", nullable = true)
    var roles : String? = null

    @Column(name = "email", nullable = false)
    var email : String? = null

    @Column(name = "phone")
    var phone : String? = null

    @Column(name = "number")
    var number : String? = null

    var created : LocalDateTime? = null
    var updated : LocalDateTime? = null

    @PrePersist
    fun prePersist(){
        created = LocalDateTime.now()
        updated = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpdate(){
        updated = LocalDateTime.now()
    }

    override fun toString(): String {
        return "User(username=$username, firstName=$firstName, lastName=$lastName, password=$password, roles=$roles, email=$email, phone=$phone, created=$created, updated=$updated)"
    }


}