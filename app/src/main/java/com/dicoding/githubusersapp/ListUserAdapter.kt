package com.dicoding.githubusersapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.githubusersapp.databinding.ItemRowProfileBinding

class ListUserAdapter(private val listUser: ArrayList<User>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    class ListViewHolder(var binding: ItemRowProfileBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (dataUsername, dataFollower, dataFollowing, dataRepositories, dataAvatar) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(dataAvatar)
            .circleCrop()
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemUsername.text = dataUsername
        holder.binding.tvItemFollower.text = holder.itemView.context.getString(R.string.follower, dataFollower)
        holder.binding.tvItemFollowing.text = holder.itemView.context.getString(R.string.following, dataFollowing)
        holder.binding.tvItemRepositories.text = holder.itemView.context.getString(R.string.repositories, dataRepositories)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listUser.size

}