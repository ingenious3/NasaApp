package com.android.nasaapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.android.nasaapp.ui.viewmodel.AppViewModel

open class BaseFragment : Fragment() {

    private lateinit var viewmodel: AppViewModel

    protected fun getViewModel(): AppViewModel {
        return viewmodel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            viewmodel = activity?.run { ViewModelProviders.of(this).get(AppViewModel::class.java)
            } ?: throw Exception("Something went wrong")
        } catch (e: Exception) {
            Log.e(BaseFragment::class.java.name, e.toString())
        }
    }


}