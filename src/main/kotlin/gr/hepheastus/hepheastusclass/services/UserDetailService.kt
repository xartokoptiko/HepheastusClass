package gr.hepheastus.hepheastusclass.services

import gr.hepheastus.hepheastusclass.repositories.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailService(val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            .orElseThrow { UsernameNotFoundException("User not found with username: $username") }

        return User.builder()
            .username(user!!.username)
            .password(user.password)
            .roles(user.roles) // Roles can be stored as a comma-separated string or a collection
            .build()
    }

}