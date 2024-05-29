package gr.hepheastus.hepheastusclass.services

import gr.hepheastus.hepheastusclass.models.User
import gr.hepheastus.hepheastusclass.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun getAllUsers() : List<User> = userRepository.findAll()

    fun getUserByUsername(username : String) : User =  userRepository.findByUsername(username)
        .orElse(null)

    fun createUser(user : User) : User {
        user.password =  "{noop}" +  user.password
        return userRepository.saveAndFlush(user)
    }

    fun deleteUserByUsername(username : String) = userRepository.deleteById(username)
}