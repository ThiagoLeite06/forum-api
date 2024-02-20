package com.thiagoleite.forum.mapper

interface IMapper<T, U> {
    fun map(t: T): U
}