package com.thiagoleite.forum.service

import com.thiagoleite.forum.model.Topic
import com.thiagoleite.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var users: List<User>) {

    init {
        val user = User(
            id = 1,
            name = "Ana da Silva",
            email = "ana@email.com.br"
        )
        users = Arrays.asList(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter { u ->
            u.id == id
        }.findFirst().get()
    }
}