package com.android.nasaapp.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(fragment: Fragment, container: Int) {
    val className = fragment.javaClass.name
    if(!fragment.isAdded) {
        supportFragmentManager
            .beginTransaction()
            .replace(container, fragment, className)
            .commit()
    }
}