package com.kotlin.invictus.daggerkotlin.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.kotlin.invictus.daggerkotlin.repository.UserRepository
import com.kotlin.invictus.daggerkotlin.utils.AbsentLiveData
import com.kotlin.invictus.daggerkotlin.vo.Repo
import com.kotlin.invictus.daggerkotlin.vo.Resource
import com.kotlin.invictus.daggerkotlin.vo.User
import javax.inject.Inject


class UserViewModel
@Inject constructor(userRepository: UserRepository) : ViewModel() {

    private val _login = MutableLiveData<String>()

    val login: LiveData<String>
        get() = _login

    val user: LiveData<Resource<User>> = Transformations
            .switchMap(_login) { login ->
                if (login == null) {
                    AbsentLiveData.create()
                } else {
                    userRepository.loadUser(login)
                }
            }

    fun setLogin(login: String?) {
        if (_login.value != login) {
            _login.value = login
        }
    }

    fun retry() {
        _login.value?.let {
            _login.value = it
        }
    }
}