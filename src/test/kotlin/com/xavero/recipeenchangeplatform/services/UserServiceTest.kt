package com.xavero.recipeenchangeplatform.services

import com.xavero.recipeenchangeplatform.entities.User
import com.xavero.recipeenchangeplatform.repositories.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

class UserServiceTest {

    @InjectMocks
    lateinit var userService: UserService

    @Mock
    lateinit var userRepository: UserRepository

    @BeforeEach
    fun setup(){
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `find user by id`(){
        val user = User(id=1L, username = "test", password = "test", email = "test@test.com")
        Mockito.`when`(userRepository.findById(1L)).thenReturn(Optional.of(user))

        val result = userService.getUserById(1L)

        assertEquals(user, result)
    }

    @Test
    fun `create user`() {
        val user = User(id = null, username = "test", password = "password123", email = "test@test.com")
        Mockito.`when`(userRepository.save(user)).thenReturn(user.copy(id = 2L))

        val result = userService.createUser(user)

        assertEquals(2L, result.id)
    }

    @Test
    fun `delete user by id`() {
        val idToDelete = 3L
        Mockito.`when`(userRepository.existsById(idToDelete)).thenReturn(true)
        Mockito.doNothing().`when`(userRepository).deleteById(idToDelete)

        userService.deleteUser(idToDelete)

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(idToDelete)
    }

}