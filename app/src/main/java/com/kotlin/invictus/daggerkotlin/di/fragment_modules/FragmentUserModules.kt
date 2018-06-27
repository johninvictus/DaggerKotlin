package com.kotlin.invictus.daggerkotlin.di.fragment_modules

import com.kotlin.invictus.daggerkotlin.ui.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentUserModules {

    @ContributesAndroidInjector
    abstract fun contributeUserFragment(): UserFragment
}