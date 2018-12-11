fun String.isOneOfThese(vararg strings: String): Boolean = strings.contains(this.toLowerCase())

class FinalEmptyClass // cannot be used as a parent class
enum class Gender(val greeting: String) { Male("Mr."), Female("Mrs."), Other("Eer.") }
open class UserBase(val name: String)
open class Employee(val firstName: String, val lastName: String, private val gender: Gender, var countryCode: String)
    : UserBase("{$firstName}_{$lastName}") {
    init {
        if (!this.isThirdGenderRecognized) {
            throw Exception("Third gender is unrecognized")
        }
    }
    open fun greet() {
        "Hello, ${gender.greeting} $firstName $lastName";
    }
    protected open val isThirdGenderRecognized: Boolean
        get() = !countryCode.isOneOfThese("hu", "cz", "pl", "ro", "rs", "mk")
}
class UsPerson(firstName: String, lastName: String, gender: Gender)
    : Employee(firstName,lastName,gender,"us") {
    override fun greet() {
        super.greet()
    }
}
class HungarianPerson(firstName: String, lastName: String, gender: Gender)
    : Employee(firstName,lastName,gender,"hu") {
    override fun greet() {
        "Udv, $firstName $lastName";
    }
    override val  isThirdGenderRecognized: Boolean
        get() = false
}

