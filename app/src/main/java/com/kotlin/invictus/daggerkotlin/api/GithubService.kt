package com.kotlin.invictus.daggerkotlin.api

import android.arch.lifecycle.LiveData
import com.kotlin.invictus.daggerkotlin.vo.Repo
import com.kotlin.invictus.daggerkotlin.vo.User
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{login}")
    fun getUser(@Path("login") login: String): LiveData<ApiResponse<User>>

    @GET("users/{login}/repos")
    fun getRepos(@Path("login") login: String): LiveData<ApiResponse<List<Repo>>>


}