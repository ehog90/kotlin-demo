package com.bence.ujj.kotlindemo


operator fun <T> List<T>.div(other: List<T>): List<T> =
        this.filterNot { other.contains(it) }

fun List<String>.print() =
        println(this.foldRight("") { curr, acc -> "$acc - $curr" })


fun main(args: Array<String>) {
    val a = listOf("alpha", "beta", "gamma")
    val b = listOf("gamma", "delta", "zeta")
    val d = a / b
    d.print()
    // - beta - alpha
}