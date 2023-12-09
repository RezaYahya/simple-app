package com.example.userfriendly.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.userfriendly.Dao.UserDao

class UserViewModelFactory(private val repository: UserDao) : ViewModelProvider.Factory {
    override fun <A : ViewModel> create(modelClass: Class<A>, extras: CreationExtras): A {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository) as A
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}