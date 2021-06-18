package com.krunal.brainvire.ui.fragment.userDetail

import android.util.Log
import android.view.View
import com.krunal.brainvire.R
import com.krunal.brainvire.api.response.UserResponse
import com.krunal.brainvire.databinding.FragmentUserDetailBinding
import com.krunal.brainvire.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment<FragmentUserDetailBinding>() {

    override fun layoutId(): Int = R.layout.fragment_user_detail

    override fun initView(view: View) {

        val obj =
            gson.fromJson(arguments?.getString("data", "{}"), UserResponse.UserRes::class.java)
        getDataBinding().user = obj
        Log.d("TAG", "initView: ")
    }
}