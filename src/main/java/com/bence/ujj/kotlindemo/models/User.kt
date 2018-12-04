package com.bence.ujj.kotlindemo.models

import org.bson.types.ObjectId
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotNull

@Document
data class User(@Id val mongoId: ObjectId,
                @NotNull(message = "Unique ID is mandatory") @Indexed(unique = true) @Length(min = 5, max = 5) val userId: String,
                @NotNull(message = "Name fields are mandatory") val nameParts: NameParts,
                val title: String?)
/*
@Document
public class User {
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