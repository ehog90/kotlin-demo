fun main(args: Array<String>)  {
    val greeter = Greeter()
    println(greeter.greet())
}


class Greeter(val name: String? = null) {
    fun greet(): String = "Hello, ${name ?: "alien"}"
}