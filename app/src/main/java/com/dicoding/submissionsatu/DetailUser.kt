package com.dicoding.submissionsatu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailUser : AppCompatActivity() {
    companion object{
        const val EXTRA_USER ="extra_user"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvUsername: TextView = findViewById(R.id.detail_username)
        val tvFollower: TextView = findViewById(R.id.detail_follower)
        val tvFollowing: TextView = findViewById(R.id.detail_following)
        val tvRepositories: TextView = findViewById(R.id.detail_repositories)
        val imgAvatar: ImageView = findViewById(R.id.detail_avatar)
        val tvName: TextView = findViewById(R.id.detail_name)
        val tvCompany: TextView = findViewById(R.id.detail_company)
        val tvLocation: TextView = findViewById(R.id.detail_location)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val avatarImage = user.data_avatar
        val usernameText = user.data_username
        val nameText = user.data_name
        val companyText = user.data_company
        val locationText = user.data_location
        val followerText = user.data_follower
        val followingText = user.data_following
        val repositoriesText = user.data_repositories
        Glide.with(this)
             .load(avatarImage)
             .circleCrop()
             .into(imgAvatar)
        tvUsername.text = usernameText
        tvName.text = nameText
        tvCompany.text = companyText
        tvLocation.text = locationText
        tvFollower.text = "Follower: $followerText"
        tvFollowing.text = "Following: $followingText"
        tvRepositories.text = "Repositories: $repositoriesText"
        Log.d("Detail Name", user.data_name)
    }
}