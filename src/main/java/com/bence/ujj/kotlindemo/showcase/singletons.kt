package com.bence.ujj.kotlindemo.showcase

import java.util.*

object singleton {
    var anyProperty: Int = 1
    val immutableProperty: Int = 4
    fun anyFunction() {

    }
}
interface IStat {
    val usersCreatedByGender: Map<Gender, Int>
}
class UserWithCompanionObject(override val name: String,
                              override val birthDate: Date,
                              override val gender: Gender) : IUser {
    companion object {
        var usersCreated = 0
    }
    object genderStatistics : IStat {
        override val usersCreatedByGender = mapOf<Gender, Int>()
    }
}
