package com.thiagoleite.forum.mapper

import com.thiagoleite.forum.dtos.TopicView
import com.thiagoleite.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: IMapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            createdAt = t.createdAt,
            status = t.status
        )
    }
}