package com.bence.ujj.kotlindemo.utils

import java.util.*

fun String.getRandomCharacter(): Char =
        this[Random().nextInt((this.length))]