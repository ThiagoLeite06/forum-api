package com.thiagoleite.forum.service

import com.thiagoleite.forum.model.Course
import com.thiagoleite.forum.model.Topic
import com.thiagoleite.forum.model.User
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class TopicService(private var topics: List<Topic>) {

    init {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            course = Course (
                id = 1,
                name = "Kotlin",
                category =  "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic2 = Topic(
            id = 2,
            title = "Duvida Android",
            message = "Variaveis no Kotlin",
            course = Course (
                id = 1,
                name = "Kotlin",
                category =  "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        val topic3 = Topic(
            id = 3,
            title = "Duvida iOS",
            message = "Variaveis no Kotlin",
            course = Course (
                id = 1,
                name = "Kotlin",
                category =  "Programacao"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        topics = Arrays.asList(topic, topic2, topic3)
    }
    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }
}