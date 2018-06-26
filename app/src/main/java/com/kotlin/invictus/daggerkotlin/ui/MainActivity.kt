package com.kotlin.invictus.daggerkotlin.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.invictus.daggerkotlin.R
import com.kotlin.invictus.daggerkotlin.utils.Info
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast(info.text)

    }
}
