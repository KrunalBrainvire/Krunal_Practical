package com.krunal.brainvire.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.krunal.brainvire.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller = Navigation.findNavController(this, R.id.hostFragment)

    }

    public fun showLoading() {
        pBar.visibility = View.VISIBLE
    }

    public fun hideLoading() {
        pBar.visibility = View.GONE
    }


}