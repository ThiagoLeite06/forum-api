package com.thiagoleite.forum.model

import java.time.LocalDateTime

data class Topic(
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: Status = Status.NOT_ANSWERED,
    val responses: List<QuestionResponse> = ArrayList()
)
