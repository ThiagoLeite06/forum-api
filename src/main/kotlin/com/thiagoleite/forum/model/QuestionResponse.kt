package com.thiagoleite.forum.model

import java.time.LocalDateTime

data class QuestionResponse(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: Topic,
    val solved: Boolean
)