package com.fininfo.interviewtask.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.fininfo.interviewtask.R
import com.fininfo.interviewtask.objmodel.UserInfo

class UserListAdapter(private val mUserList: ArrayList<UserInfo>) :
    RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {


    class UserListViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName);
        val tvUserAge: TextView = itemView.findViewById(R.id.tvUserAge);
        val tvUserCity: TextView = itemView.findViewById(R.id.tvUserCity);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_layout, parent, false)
        return UserListViewHolder(view)
    }


    override fun getItemCount(): Int {
        return mUserList.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val mUserInfoModel = mUserList.get(position)

        holder.tvUserName.text = mUserInfoModel.name
        holder.tvUserAge.text = mUserInfoModel.age.toString() + " Years"
        holder.tvUserCity.text = mUserInfoModel.city
    }





}