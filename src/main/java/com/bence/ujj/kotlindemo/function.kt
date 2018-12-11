private fun echo(str: String) = println(str)
fun echo(str: Array<String>) {
    for (i in 0..str.size) {
        echo(str[i])
    }
}
infix fun String.surround(str: String): String =
        "$str${this}$str"
fun List<String>.myMap(fn: (String) -> String) = this.map(fn);
fun main(args: Array<String>) {
    //infix function
    println("test" surround  "-" surround "!") //!-test-!
    val function: (String) -> String = {
        when (it) {
            "one" ->"ONE"
            "two" ->"TWO"
            else -> it.toLowerCase() + "OTHER"
        }
    }
    val a = listOf("one, two, tree").myMap(function)
    // ONE, TWO, threeOTHER
}
