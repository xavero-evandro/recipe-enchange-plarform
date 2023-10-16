package com.xavero.recipeenchangeplatform.repositories

import com.xavero.recipeenchangeplatform.entities.User
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun `save user`(){
        val user = User(
            id = null,
            username = "test",
            password = "test",
            email = "test@test.com")
        val savedUser = userRepository.save(user)
        Assertions.assertNotNull(savedUser.id)
    }

}