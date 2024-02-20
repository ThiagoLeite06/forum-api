package com.thiagoleite.forum.dtos

import com.thiagoleite.forum.model.Status
import java.time.LocalDateTime

data class TopicView (
    val id: Long?,
    val title: String,
    val message: String,
    val status: Status,
    val createdAt: LocalDateTime
)


