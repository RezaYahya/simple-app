package com.example.userfriendly.Repo

import androidx.lifecycle.LiveData
import com.example.userfriendly.Dao.UserDao
import com.example.userfriendly.Entity.User

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}