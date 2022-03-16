package com.dicoding.githubusersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.dicoding.githubusersapp.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val avatarImage = user.dataAvatar
        val usernameText = user.dataUsername
        val nameText = user.dataName
        val companyText = user.dataCompany
        val locationText = user.dataLocation
        val followerText = user.dataFollower
        val followingText = user.dataFollowing
        val repositoriesText = user.dataRepositories
        Glide.with(this)
             .load(avatarImage)
             .circleCrop()
             .into(binding.detailAvatar)
        binding.detailUsername.text = usernameText
        binding.detailName.text = nameText
        binding.detailCompany.text = companyText
        binding.detailLocation.text = locationText
        binding.detailFollower.text = followerText
        binding.detailFollowing.text = followingText
        binding.detailRepositories.text = repositoriesText
        Log.d("Detail Name", user.dataName)
    }

    companion object{
        const val EXTRA_USER ="extra_user"
    }
}