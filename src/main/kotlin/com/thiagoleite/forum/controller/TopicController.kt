package com.thiagoleite.forum.controller

import com.thiagoleite.forum.model.Course
import com.thiagoleite.forum.model.Topic
import com.thiagoleite.forum.model.User
import com.thiagoleite.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topic")
class TopicController(
    private val service: TopicService
){

    @GetMapping
    fun list(): List<Topic> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Topic {
        return service.getById(id)
    }
}