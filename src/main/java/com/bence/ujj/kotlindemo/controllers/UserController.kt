package com.bence.ujj.kotlindemo.controllers

import com.bence.ujj.kotlindemo.database.UserRepository
import com.bence.ujj.kotlindemo.misc.queryStat
import com.bence.ujj.kotlindemo.models.Gender
import com.bence.ujj.kotlindemo.models.NameParts
import com.bence.ujj.kotlindemo.models.StoredUser
import com.bence.ujj.kotlindemo.utils.generateId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class UserController(@Autowired val userRepository: UserRepository) {

    @RequestMapping("/users")
    fun getAllUsers(): List<StoredUser> {
        queryStat.allQueryHitCount += 1
        println("Query hit count for all users: ${queryStat.allQueryHitCount}")
        return userRepository.findAll()
    }

    @RequestMapping(value = ["/users"], method = [RequestMethod.POST])
    fun addUser(@Valid @RequestBody(required = true) storedUser: StoredUser) = userRepository.save(storedUser)

    @RequestMapping(value = ["/users/{userId}"], method = [RequestMethod.PUT])
    fun queryForUser(@PathVariable("userId") userId: String) =
            userRepository.findByUserId(userId).map { x -> ResponseEntity(x, HttpStatus.OK) }.orElse(ResponseEntity(HttpStatus.NOT_FOUND))!!

    @RequestMapping(value = ["/users/{userId}/promote-vp"], method = [RequestMethod.PUT])
    fun promoteVp(@PathVariable("userId") userId: String) =
            userRepository.findByUserId(userId).map {
                val response = when (it.title) {
                    "VP" -> ResponseEntity(it, HttpStatus.NOT_MODIFIED)
                    else -> {
                        it.title = "VP"
                        userRepository.save(it)
                        ResponseEntity(it, HttpStatus.OK)
                    }
                }
                response
            }.orElse(ResponseEntity(HttpStatus.NOT_FOUND))!!


    @RequestMapping(value = ["/users"], method = [RequestMethod.PUT])
    fun AddUserFromParameters(@RequestParam("firstName") firstName: String,
                              @RequestParam("lastName") lastName: String,
                              @RequestParam("title") title: String,
                              @RequestParam("gender") gender: Gender) =
            userRepository.save(StoredUser(generateId(6), NameParts(firstName, lastName), title, gender))


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
    public List<StoredUser> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@Valid @RequestBody(required = true) StoredUser user) {
        userRepository.save(user);
    }
}

 */