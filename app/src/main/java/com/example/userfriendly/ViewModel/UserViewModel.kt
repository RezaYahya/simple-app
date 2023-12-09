package com.example.userfriendly.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userfriendly.Dao.UserDao
import com.example.userfriendly.Entity.User
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserDao) : ViewModel() {
    val allUsers: LiveData<List<User>> = repository.getAllUsers()

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        repository.deleteUser(user)
    }
}