package com.kotlin.invictus.daggerkotlin

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import com.kotlin.invictus.daggerkotlin.di.component.AppComponent
import com.kotlin.invictus.daggerkotlin.di.component.DaggerAppComponent


class DaggerKotlinApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build()

        appComponent.inject(this)
        return appComponent
    }
}