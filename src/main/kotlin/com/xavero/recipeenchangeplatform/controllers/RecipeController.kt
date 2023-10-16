package com.xavero.controllers

import com.xavero.recipeenchangeplatform.entities.Recipe
import com.xavero.recipeenchangeplatform.services.RecipeService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/recipes")
class RecipeController(private val recipeService: RecipeService) {

    @GetMapping
    fun getAllRecipes(): List<Recipe> = recipeService.getAllRecipes()

    @GetMapping("/{id}")
    fun getRecipeById(@PathVariable id: Long): Recipe? = recipeService.getRecipeById(id)

    @PostMapping
    fun createRecipe(@Validated @RequestBody recipe: Recipe): Recipe = recipeService.createRecipe(recipe)

    @PutMapping("/{id}")
    fun updateRecipe(@PathVariable id: Long, @RequestBody recipe: Recipe): Recipe = recipeService.updateRecipe(id, recipe)

    @DeleteMapping("/{id}")
    fun deleteRecipe(@PathVariable id: Long) = recipeService.deleteRecipe(id)
}
