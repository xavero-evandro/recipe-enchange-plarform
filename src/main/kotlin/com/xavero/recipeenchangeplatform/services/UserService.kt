package com.xavero.recipeenchangeplatform.services

import com.xavero.exceptions.ResourceNotFoundException
import com.xavero.recipeenchangeplatform.entities.User
import com.xavero.recipeenchangeplatform.repositories.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(user: User): User = userRepository.save(user)

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User? = userRepository.findById(id).orElseThrow{ ResourceNotFoundException("User with id $id not found") }

    fun updateUser(id: Long, user: User): User {
        if (userRepository.existsById(id)) {
            val userToUpdate = userRepository.findById(id).get()
            userToUpdate.username = user.username
            userToUpdate.email = user.email
            userToUpdate.password = user.password
            return userRepository.save(userToUpdate)
        } else {
            throw ResourceNotFoundException("User with id $id not found")
        }
    }

    fun deleteUser(id: Long) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
        } else {
            throw ResourceNotFoundException("User with id $id not found")
        }
    }

}