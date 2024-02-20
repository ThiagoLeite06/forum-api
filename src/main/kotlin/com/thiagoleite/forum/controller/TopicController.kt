package com.thiagoleite.forum.controller

import com.thiagoleite.forum.dtos.NewTopicForm
import com.thiagoleite.forum.dtos.TopicView
import com.thiagoleite.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topic")
class TopicController(
    private val service: TopicService
){
    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicView {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid dto: NewTopicForm) {
        service.createTopic(dto)
    }
}