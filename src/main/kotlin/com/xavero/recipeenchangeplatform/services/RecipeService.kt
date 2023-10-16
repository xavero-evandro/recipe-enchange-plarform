package com.xavero.recipeenchangeplatform.services

import com.xavero.exceptions.ResourceNotFoundException
import com.xavero.recipeenchangeplatform.entities.Recipe
import com.xavero.recipeenchangeplatform.repositories.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeService(private val recipeRepository: RecipeRepository){

    fun createRecipe(recipe: Recipe): Recipe = recipeRepository.save(recipe)

    fun getAllRecipes(): List<Recipe> = recipeRepository.findAll()

    fun getRecipeById(id: Long): Recipe = recipeRepository.findById(id).orElseThrow { ResourceNotFoundException("Recipe with id $id not found") }

    fun updateRecipe(id: Long, recipe: Recipe): Recipe {
        if (recipeRepository.existsById(id)) {
            val recipeToUpdate = recipeRepository.findById(id).get()
            recipeToUpdate.name = recipe.name
            recipeToUpdate.description = recipe.description
            recipeToUpdate.ingredients = recipe.ingredients
            recipeToUpdate.steps = recipe.steps
            return recipeRepository.save(recipeToUpdate)
        } else {
            throw ResourceNotFoundException("Recipe with id $id not found")
        }
    }

    fun deleteRecipe(id: Long) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id)
        } else {
            throw ResourceNotFoundException("Recipe with id $id not found")
        }
    }


}
