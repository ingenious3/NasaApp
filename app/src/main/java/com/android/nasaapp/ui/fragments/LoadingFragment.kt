package com.android.nasaapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.nasaapp.R

class LoadingFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.fragment_loading, container, false)
        return contentView
    }

    companion object {
        @JvmStatic
        fun getInstance() : LoadingFragment {
            return LoadingFragment()
        }
    }
}