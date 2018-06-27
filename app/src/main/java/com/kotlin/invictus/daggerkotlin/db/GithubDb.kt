package com.kotlin.invictus.daggerkotlin.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kotlin.invictus.daggerkotlin.db.dao.UserDao
import com.kotlin.invictus.daggerkotlin.vo.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class GithubDb : RoomDatabase() {
    abstract fun userDao(): UserDao
}