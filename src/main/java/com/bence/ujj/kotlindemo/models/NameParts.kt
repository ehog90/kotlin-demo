package com.bence.ujj.kotlindemo.models

data class NameParts(val firstName: String, val lastName: String) {
    val formattedName
        get() = "$firstName $lastName"
}