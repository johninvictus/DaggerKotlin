package com.kotlin.invictus.daggerkotlin.di.component


import com.kotlin.invictus.daggerkotlin.DaggerKotlinApp
import com.kotlin.invictus.daggerkotlin.di.modules.ActivityBuilder
import com.kotlin.invictus.daggerkotlin.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class
])
interface AppComponent : AndroidInjector<DaggerKotlinApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DaggerKotlinApp): Builder

        fun build(): AppComponent
    }

    override fun inject(app: DaggerKotlinApp)
}