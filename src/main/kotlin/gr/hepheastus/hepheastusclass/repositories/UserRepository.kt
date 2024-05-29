package gr.hepheastus.hepheastusclass.repositories

import gr.hepheastus.hepheastusclass.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, String> {

    @Query("select u from User u where u.username = ?1")
    fun findByUsername(username: String): Optional<User>
}