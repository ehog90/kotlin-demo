package com.bence.ujj.kotlindemo.showcase

import java.util.*

interface ICallable {
    val phoneNumber: String
    fun call()
    fun greet() = call()
}

interface IUser {
    fun greet() = println("hello")
    val name: String
    val birthDate: Date
    val gender: Gender
}

data class User(override val name: String, override val birthDate: Date,
                override val gender: Gender, override val phoneNumber: String) : IUser, ICallable {
    override fun call() {
        super<ICallable>.greet()
    }

    override fun greet() = println("Hello, $name")
}



