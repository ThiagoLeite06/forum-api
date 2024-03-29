package com.thiagoleite.forum.controller

import com.thiagoleite.forum.dtos.NewTopicForm
import com.thiagoleite.forum.dtos.TopicView
import com.thiagoleite.forum.dtos.UpdateTopicForm
import com.thiagoleite.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
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
    fun create(
            @RequestBody @Valid form: NewTopicForm,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topic = service.createTopic(form)
        val uri = uriBuilder.path("topics/${topic.id}").build().toUri()

        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
        var topicView = service.update(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}