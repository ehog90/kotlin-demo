package com.bence.ujj.kotlindemo.models
import org.junit.Assert.*
import org.junit.Test


class UserTest {

    val user1 = StoredUser("44LPAA", NameParts("Bence", "Ujj"), "Mr", Gender.Other)
    val user2 = StoredUser("66LZZA", NameParts("Bence", "Ujj"), "Mr", Gender.Other)
    val user3 = StoredUser("44LPAA", NameParts("Bela", "Toth"), "Mr", Gender.Other)

    @Test
    fun testUserNameEquality() {
        assertTrue("Same names", user1 hasTheSameName user2)
    }

    @Test
    fun testUserNameInEquality() {
        assertFalse("Different names", user1 hasTheSameName user3)
    }

}
