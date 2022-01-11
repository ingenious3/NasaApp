package com.android.nasaapp.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class AppViewModelFactory @Inject constructor(private val viewModelsMap: Map<Class<out ViewModel>,
        @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(model: Class<T>): T {
        val creator = viewModelsMap[model] ?: viewModelsMap.asIterable().firstOrNull {
            model.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown class")
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}