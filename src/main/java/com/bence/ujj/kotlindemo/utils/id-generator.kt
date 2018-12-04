package com.bence.ujj.kotlindemo.utils


val acceptableCharacters = "1234567890QWERTYUIOPASDF"

fun generateId(length: Int): String =
        (1..length).fold("") { acc, _ -> acc + acceptableCharacters.getRandomCharacter() }