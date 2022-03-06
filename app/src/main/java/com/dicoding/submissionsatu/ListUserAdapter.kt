package com.dicoding.submissionsatu

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var tvFollower: TextView = itemView.findViewById(R.id.tv_item_follower)
        var tvFollowing: TextView = itemView.findViewById(R.id.tv_item_following)
        var tvRepositories: TextView = itemView.findViewById(R.id.tv_item_repositories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_profile, parent, false)
        return ListViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (data_username, data_follower, data_following, data_repositories, data_avatar) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(data_avatar)
            .circleCrop()
            .into(holder.imgAvatar)
        holder.tvUsername.text = data_username
        holder.tvFollower.text = "Follower: $data_follower"
        holder.tvFollowing.text = "Following: $data_following"
        holder.tvRepositories.text = "Repositories: $data_repositories"
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listUser.size

}