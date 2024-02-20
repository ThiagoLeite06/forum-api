package com.thiagoleite.forum.service

import com.thiagoleite.forum.dtos.NewTopicForm
import com.thiagoleite.forum.dtos.TopicView
import com.thiagoleite.forum.mapper.TopicFormMapper
import com.thiagoleite.forum.mapper.TopicViewMapper
import com.thiagoleite.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun list(): List<TopicView> {
        return topics.stream().map { it ->
            topicViewMapper.map(it)
        }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicView {
        val topic = topics.stream().filter { it ->
            it.id == id
        }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun createTopic(form: NewTopicForm) {
       val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }
}