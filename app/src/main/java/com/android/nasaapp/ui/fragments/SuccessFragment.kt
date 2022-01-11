package com.android.nasaapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.nasaapp.R
import com.android.nasaapp.utils.getCurrentDateString
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.fragment_success, container, false)
        return contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        val apiResponse = getViewModel().resultGetData?.value

        Glide.with(this)
            .load(apiResponse?.url ?: "")
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(1)))
            .into(img)

        title_text.text = apiResponse?.title ?: "Unknown Title"
        desc_text.text = apiResponse?.explanation ?: "Explanation is missing"

        info_text.visibility = if (!getCurrentDateString().equals(apiResponse?.date)) View.VISIBLE else View.GONE

    }

    companion object {
        @JvmStatic
        fun getInstance() : SuccessFragment {
            return SuccessFragment()
        }
    }

}