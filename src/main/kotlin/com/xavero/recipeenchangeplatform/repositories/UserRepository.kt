package com.xavero.recipeenchangeplatform.repositories

import com.xavero.recipeenchangeplatform.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}