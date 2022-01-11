package com.android.nasaapp.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class KeyViewModel(val value: KClass<out ViewModel>)