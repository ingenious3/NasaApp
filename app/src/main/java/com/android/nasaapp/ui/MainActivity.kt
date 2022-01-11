package com.android.nasaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.nasaapp.NasaApp
import com.android.nasaapp.R
import com.android.nasaapp.ui.fragments.FailureFragment
import com.android.nasaapp.ui.fragments.LoadingFragment
import com.android.nasaapp.ui.fragments.SuccessFragment
import com.android.nasaapp.ui.viewmodel.AppViewModel
import com.android.nasaapp.utils.States
import com.android.nasaapp.utils.replaceFragment
import com.android.nasaapp.utils.viewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var loadingFragment: LoadingFragment? = null
    var failureFragment: FailureFragment? = null
    var successFragment: SuccessFragment? = null

    private val appComponent by lazy { NasaApp.appComponents }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private fun getViewModel(): AppViewModel {
        return viewModelProvider(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        initObservers()
        getViewModel().setState(States.API_CALL_IN_PROGRESS)
    }

    fun initObservers() {

        getViewModel().resultGetData.observe(this, Observer {
            if (it != null) {
                getViewModel().setState(States.API_CALL_SUCCESS)
            }
        })

        getViewModel().errorGetData.observe(this, Observer {
            if (it != null) {
                getViewModel().setState(States.API_CALL_FAILURE)
            }
        })

        getViewModel().currentState.observe(this, Observer {
            if (it != null) {
                onStateChanged(it)
            }
        })
    }


    fun onStateChanged(state: States) {
        when(state) {
            States.API_CALL_IN_PROGRESS -> {
                replaceFragment(getLoadingFragmentView(), R.id.container_layout)
                getViewModel().getData()
            }
            States.API_CALL_FAILURE -> {
                replaceFragment(getFailureFragmentView(), R.id.container_layout)
            }
            States.API_CALL_SUCCESS -> {
                replaceFragment(getSuccessFragmentView(), R.id.container_layout)
            }
        }
    }

    fun getLoadingFragmentView(): LoadingFragment {
        if (loadingFragment == null) {
            loadingFragment = LoadingFragment.getInstance()
        }
        return loadingFragment as LoadingFragment
    }

    fun getFailureFragmentView(): FailureFragment {
        if (failureFragment == null) {
            failureFragment = FailureFragment.getInstance()
        }
        return failureFragment as FailureFragment
    }

    fun getSuccessFragmentView(): SuccessFragment {
        if (successFragment == null) {
            successFragment = SuccessFragment.getInstance()
        }
        return successFragment as SuccessFragment
    }
}