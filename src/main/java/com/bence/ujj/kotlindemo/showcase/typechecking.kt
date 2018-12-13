package com.bence.ujj.kotlindemo.showcase

import java.lang.Exception

fun main(args: Array<String>) {
    reverse("morgan")
}

fun reverse(obj: Any): String {
    if (obj is String) {
        return obj.reversed()
    }
    throw Exception("It's not a string!")

}