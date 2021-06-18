package com.krunal.brainvire.ui.fragment.userList

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.krunal.brainvire.R
import com.krunal.brainvire.`interface`.ListClickListener
import com.krunal.brainvire.api.APIStatus
import com.krunal.brainvire.api.ApiState
import com.krunal.brainvire.api.response.UserResponse
import com.krunal.brainvire.databinding.FragmentUserListBinding
import com.krunal.brainvire.ui.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user_list.*
import java.util.*


@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserListBinding>() {

    private lateinit var userAdapter: UserAdapter;
    private val viewModel: UserViewModel by viewModels()
    var page = 1
    override fun layoutId(): Int = R.layout.fragment_user_list


    @SuppressLint("SetTextI18n")
    override fun initView(view: View) {
        val listener = object : ListClickListener {
            override fun onClickListener(view: View, pos: Int, objects: Any) {
                val bundle = Bundle()
                bundle.putString("data", gson.toJson(objects as UserResponse.UserRes))
                controller.navigate(R.id.frg_user_detail, bundle)
            }

        }
        userAdapter = UserAdapter(glide, listener)
        rvMenu.adapter = userAdapter

        rvMenu.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    page += 1;
                    getUserData()
                }
            }
        })

        getUserData()
    }

    private fun getUserData() {
        viewModel.getMenu(page.toString(), "10").observe(this, getReteObserver())
    }

    private fun getReteObserver(): Observer<ApiState<UserResponse>> {
        return Observer {
            when (it.ApiStatus) {
                APIStatus.LOADING -> {
                    activityApp.showLoading()

                }
                APIStatus.SUCCESS -> {
                    activityApp.hideLoading()
                    Log.d("TAG", "getReteObserver: " + it.data)
                    userAdapter.addData(it.data?.results!!)
                    rvMenu.visibility = View.VISIBLE
                    tvNoDataFound.visibility = View.GONE

                }
                APIStatus.ERROR -> {
                    activityApp.hideLoading()
                    rvMenu.visibility = View.GONE
                    tvNoDataFound.visibility = View.VISIBLE
                }
            }

        }
    }
}