package com.kotlin.invictus.daggerkotlin.repository

import android.arch.lifecycle.LiveData
import com.kotlin.invictus.daggerkotlin.api.GithubService
import com.kotlin.invictus.daggerkotlin.db.dao.UserDao
import com.kotlin.invictus.daggerkotlin.utils.AppExecutors
import com.kotlin.invictus.daggerkotlin.vo.Resource
import com.kotlin.invictus.daggerkotlin.vo.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
        private val appExecutors: AppExecutors,
        private val userDao: UserDao,
        private val githubService: GithubService
) {

    fun loadUser(login: String): LiveData<Resource<User>> {
        return object : NetworkBoundResource<User, User>(appExecutors) {
            override fun saveCallResult(item: User) {
                userDao.insert(item)
            }

            override fun shouldFetch(data: User?) = data == null

            override fun loadFromDb() = userDao.findByLogin(login)

            override fun createCall() = githubService.getUser(login)
        }.asLiveData()
    }
}