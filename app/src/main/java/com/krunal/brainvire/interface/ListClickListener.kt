package com.krunal.brainvire.`interface`

import android.view.View
import java.util.*

interface ListClickListener {
    fun onClickListener(view: View, pos: Int, objects: Any)
}