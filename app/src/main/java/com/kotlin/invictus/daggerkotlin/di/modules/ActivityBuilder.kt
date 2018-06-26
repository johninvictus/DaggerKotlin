package com.kotlin.invictus.daggerkotlin.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.kotlin.invictus.daggerkotlin.ui.MainActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity
}