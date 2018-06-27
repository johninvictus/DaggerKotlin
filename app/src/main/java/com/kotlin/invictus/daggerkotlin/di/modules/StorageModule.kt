package com.kotlin.invictus.daggerkotlin.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import com.kotlin.invictus.daggerkotlin.db.GithubDb
import com.kotlin.invictus.daggerkotlin.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {
    @Singleton
    @Provides
    fun provideDb(app: Application): GithubDb {
        return Room
                .databaseBuilder(app, GithubDb::class.java, "github.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: GithubDb): UserDao {
        return db.userDao()
    }
}