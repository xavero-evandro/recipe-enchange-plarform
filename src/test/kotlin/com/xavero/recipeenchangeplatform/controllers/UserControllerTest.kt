package com.xavero.recipeenchangeplatform.controllers

import com.xavero.recipeenchangeplatform.entities.User
import com.xavero.recipeenchangeplatform.services.UserService
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class UserControllerTest {
    private lateinit var mockMvc: MockMvc

    @InjectMocks
    lateinit var userController: UserController

    @Mock
    lateinit var userService: UserService

    @BeforeEach
    fun setup(){
        MockitoAnnotations.openMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build()
    }

    @Test
    fun `get user by id`(){
        val user = User(id=1L, username = "test", password = "test", email = "test@test.com")
        Mockito.`when`(userService.getUserById(1L)).thenReturn(user)

        mockMvc.perform(get("/api/v1/users/1"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id", Matchers.`is`(1)))
            .andExpect(jsonPath("$.username", Matchers.`is`("test")))
            .andExpect(jsonPath("$.password", Matchers.`is`("test")))
            .andExpect(jsonPath("$.email", Matchers.`is`("test@test.com")))
    }

}