package com.thiagoleite.forum.service

import com.thiagoleite.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<Course>) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programacao"
        )
        courses = Arrays.asList(course)
    }

    fun findById(id: Long): Course {
        return courses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}