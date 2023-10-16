package com.xavero.recipeenchangeplatform.repositories

import com.xavero.recipeenchangeplatform.entities.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long>