package com.krunal.brainvire.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.RequestManager
import com.google.gson.Gson
import com.krunal.brainvire.ui.MainActivity
import javax.inject.Inject

abstract class BaseFragment<DataBinding : ViewDataBinding> : Fragment() {

    @Inject
    lateinit var glide: RequestManager

    @Inject
    lateinit var gson: Gson
    private lateinit var dataBinding: DataBinding

    protected lateinit var controller: NavController

    protected lateinit var activityApp: MainActivity

    abstract fun layoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityApp = getActivity() as MainActivity
        setHasOptionsMenu(true)
    }

    fun getDataBinding() = dataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller = Navigation.findNavController(view)
        initView(view)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    protected abstract fun initView(view: View)


    override fun onResume() {
        super.onResume()
        try {
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}