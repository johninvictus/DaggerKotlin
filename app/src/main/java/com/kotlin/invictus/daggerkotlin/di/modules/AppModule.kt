package com.kotlin.invictus.daggerkotlin.di.modules

import com.kotlin.invictus.daggerkotlin.api.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [
    NetworkModule::class,
    StorageModule::class]
)
class AppModule {
    @Provides
    @Singleton
    fun providesGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}