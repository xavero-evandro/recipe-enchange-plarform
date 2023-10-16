package com.xavero.recipeenchangeplatform.services

import com.xavero.recipeenchangeplatform.entities.Comment
import com.xavero.recipeenchangeplatform.repositories.CommentRepository
import org.springframework.stereotype.Service

@Service
class CommentService(private val commentRepository: CommentRepository){
    fun addComment(comment: Comment): Comment = commentRepository.save(comment)
}