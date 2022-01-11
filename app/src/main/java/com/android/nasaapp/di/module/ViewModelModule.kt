package com.android.nasaapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.nasaapp.di.viewmodel.AppViewModelFactory
import com.android.nasaapp.di.viewmodel.KeyViewModel
import com.android.nasaapp.ui.viewmodel.AppViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @KeyViewModel(AppViewModel::class)
    abstract fun bindAppViewModel(appViewModel: AppViewModel): ViewModel

    @Binds
    abstract fun bindAppViewModelFactory(appFactory: AppViewModelFactory): ViewModelProvider.Factory

}