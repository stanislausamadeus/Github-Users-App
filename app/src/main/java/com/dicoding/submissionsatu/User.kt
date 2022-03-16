package com.dicoding.submissionsatu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class User(
    var dataUsername: String,
    var dataFollower: String,
    var dataFollowing: String,
    var dataRepositories: String,
    var dataAvatar: Int,
    var dataName: String,
    var dataCompany: String,
    var dataLocation: String
) : Parcelable
