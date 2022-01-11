package com.android.nasaapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.nasaapp.R
import com.android.nasaapp.utils.States
import kotlinx.android.synthetic.main.fragment_failure.*

class FailureFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.fragment_failure, container, false)
        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListener()
    }

    fun setUpClickListener() {
        buttonRetry.setOnClickListener {
            getViewModel().setState(States.API_CALL_IN_PROGRESS)
        }
    }

    companion object {
        @JvmStatic
        fun getInstance() : FailureFragment {
            return FailureFragment()
        }
    }
}