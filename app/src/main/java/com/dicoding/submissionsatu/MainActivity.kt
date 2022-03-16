package com.dicoding.submissionsatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()

    }

    private val listUsers : ArrayList<User>
    get(){
        val listUsername = resources.getStringArray(R.array.username)
        val listName = resources.getStringArray(R.array.name)
        val listFollower = resources.getStringArray(R.array.followers)
        val listFollowing = resources.getStringArray(R.array.following)
        val listCompany = resources.getStringArray(R.array.company)
        val listLocation = resources.getStringArray(R.array.location)
        val listRepositories = resources.getStringArray(R.array.repository)
        val listAvatar = resources.obtainTypedArray(R.array.avatar)
        val listUser = ArrayList<User>()
        for (i in listUsername.indices){
            val user = User(
                listUsername[i],
                listFollower[i],
                listFollowing[i],
                listRepositories[i],
                listAvatar.getResourceId(i,-1),
                listName[i],
                listCompany[i],
                listLocation[i]
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val intentToDetail = Intent(this@MainActivity, DetailUser::class.java)
                intentToDetail.putExtra(DetailUser.EXTRA_USER, data)
                startActivity(intentToDetail)
            }
        })
    }
}