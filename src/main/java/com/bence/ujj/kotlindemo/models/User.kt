package com.bence.ujj.kotlindemo.models

import org.bson.types.ObjectId
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotNull

enum class Gender(val salutation: String) {
    Male("Mr."),
    Female("Mrs."),
    Other("Wtf.")
}

abstract class User {
    abstract val userId: String
    abstract val nameParts: NameParts
    abstract val title: String?
    abstract val gender: Gender
}

open class Employee(override val userId: String, override val nameParts: NameParts, override val gender : Gender) : User() {
    override val title: String? = null
    open val formattedName
        get() = "${gender.salutation} ${nameParts.formattedName}"

}

class VicePresident(userId: String, nameParts: NameParts, gender: Gender) : Employee(userId, nameParts, gender) {
    override val title: String? = "VP"
    override val formattedName
        get() = "${super.formattedName}, Vice President"
}


@Document
data class StoredUser(@NotNull(message = "Unique ID is mandatory") @Indexed(unique = true) @Length(min = 5, max = 5) override val userId: String,
                      @NotNull(message = "Name fields are mandatory") override val nameParts: NameParts,
                      override var title: String?,
                      @NotNull(message = "com.bence.ujj.kotlindemo.showcase.Gender is mandatory") override val gender: Gender) : User() {

    @Id
    lateinit var id: ObjectId

    init {
        ++allUsersCreated;
        println("StoredUser object is created: $prettifiedDisplay, all users created: $allUsersCreated")
    }

    private val prettifiedDisplay: String
        get() = "${nameParts.firstName} ${nameParts.lastName} ($userId)"

    companion object {
        var allUsersCreated = 0L
    }

    infix fun hasTheSameName(other: StoredUser): Boolean =
            other.nameParts == nameParts
}



/*
@Document
public class StoredUser {
    @Id
    private String mongoId;

    @NotNull(message = "Unique ID is mandatory")
    @Indexed(unique = true)
    @Length(min = 5, max = 5)
    private String userId;

    @NotNull(message = "Name fields are mandatory")
    @Indexed(unique = true)
    private NameParts name;

    @NotNull(message = "Title is mandatory")
    private String title;

    public NameParts getName() {
        return name;
    }

    public void setName(NameParts name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
 */