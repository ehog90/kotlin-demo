package com.bence.ujj.kotlindemo.controllers

import com.bence.ujj.kotlindemo.database.UserRepository
import com.bence.ujj.kotlindemo.models.NameParts
import com.bence.ujj.kotlindemo.models.User
import com.bence.ujj.kotlindemo.utils.generateId
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.query.Collation
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class UserControlle(@Autowired val userRepository: UserRepository) {

    @RequestMapping("/users")
    fun getAllUsers(): List<User> = userRepository.findAll()

    @RequestMapping(value = ["/users"], method = [RequestMethod.POST])
    fun addUser(@Valid @RequestBody(required = true) user: User) = userRepository.save(user)

    @RequestMapping(value = ["/users"], method = [RequestMethod.PUT])
    fun AddUserFromParameters(@RequestParam("firstName") firstName: String,
                              @RequestParam("lastName") lastName: String,
                              @RequestParam("title") title: String) =
            userRepository.save(User(ObjectId.get(), generateId(6), NameParts(firstName, lastName), title))

}
/*

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@Valid @RequestBody(required = true) User user) {
        userRepository.save(user);
    }
}

 */