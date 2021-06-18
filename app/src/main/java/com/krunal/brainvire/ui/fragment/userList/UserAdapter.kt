package com.krunal.brainvire.ui.fragment.userList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.krunal.brainvire.R
import com.krunal.brainvire.`interface`.ListClickListener
import com.krunal.brainvire.api.response.UserResponse
import kotlinx.android.synthetic.main.layout_menu_list.view.*

class UserAdapter(val glide: RequestManager, val listClickListener: ListClickListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val alItem = ArrayList<UserResponse.UserRes>();

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun addData(alRate: ArrayList<UserResponse.UserRes>) {
        this.alItem.addAll(alRate)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_menu_list, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = alItem.get(position)
        holder.itemView.tvFullName.text = data.name.first + " " + data.name.last
        holder.itemView.tvGender.text = "Gender : ${data.gender}"
        glide.load(data.picture.thumbnail)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.ivUser)
        holder.itemView.setOnClickListener {
            listClickListener.onClickListener(holder.itemView, position, data as Object)
        }
    }

    override fun getItemCount(): Int {
        return alItem.size
    }

}