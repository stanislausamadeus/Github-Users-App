package com.dicoding.submissionsatu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class User(
    var data_username: String,
    var data_follower: String,
    var data_following: String,
    var data_repositories: String,
    var data_avatar: Int,
    var data_name: String,
    var data_company: String,
    var data_location: String
) : Parcelable
