package com.kotlin.invictus.daggerkotlin.di.modules

import com.kotlin.invictus.daggerkotlin.di.fragment_modules.FragmentUserModules
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.kotlin.invictus.daggerkotlin.ui.MainActivity


@Suppress("unused")
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [
        FragmentUserModules::class
    ])
    internal abstract fun bindMainActivity(): MainActivity
}