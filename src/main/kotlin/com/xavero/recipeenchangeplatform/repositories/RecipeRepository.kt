package com.xavero.recipeenchangeplatform.repositories

import com.xavero.recipeenchangeplatform.entities.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository: JpaRepository<Recipe, Long>