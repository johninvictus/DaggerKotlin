package com.kotlin.invictus.daggerkotlin.ui.user

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.invictus.daggerkotlin.utils.AppExecutors
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class UserFragment : Fragment() {

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context)
    }
}