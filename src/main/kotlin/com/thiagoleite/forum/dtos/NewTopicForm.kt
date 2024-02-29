package com.thiagoleite.forum.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm(
    @field:NotEmpty(message = "Não pode ser em branco")
    @field: Size(min = 5, max = 100, message = "Titulo deve ter de 5 a 100 caracteres")
    val title: String,
    @field:NotEmpty val message: String,
    @field:NotNull val courseId: Long,
    @field:NotNull val authorId: Long
)
