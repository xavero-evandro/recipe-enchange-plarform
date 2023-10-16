package com.xavero.recipeenchangeplatform.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.jetbrains.annotations.NotNull

@Entity
data class Recipe(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @NotNull
    var name: String,
    @NotNull
    var description: String,
    @NotNull
    var ingredients: String,
    @NotNull
    var steps: String,
    var imageUrl: String? = null,
    @ManyToOne
    var user: User,
)
