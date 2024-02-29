package com.thiagoleite.forum.mapper

import com.thiagoleite.forum.dtos.NewTopicForm
import com.thiagoleite.forum.model.Topic
import com.thiagoleite.forum.service.CourseService
import com.thiagoleite.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
): IMapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.courseId),
            author = userService.findById(t.authorId)
        )
    }
}