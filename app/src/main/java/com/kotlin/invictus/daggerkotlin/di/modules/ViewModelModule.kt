package com.kotlin.invictus.daggerkotlin.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.kotlin.invictus.daggerkotlin.di.qualifires.ViewModelKey
import com.kotlin.invictus.daggerkotlin.ui.user.UserViewModel
import com.kotlin.invictus.daggerkotlin.viewmodel.GithubViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: GithubViewModelFactory): ViewModelProvider.Factory
}