package com.thiagoleite.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        val title: String,

        val message: String,

        val createdAt: LocalDateTime = LocalDateTime.now(),

        @ManyToOne
        val course: Course,

        val author: User,

        @Enumerated(value = EnumType.STRING)
        val status: Status = Status.NOT_ANSWERED,

        @OneToMany (mappedBy = "topic")
        val responses: List<QuestionResponse> = ArrayList()
)
