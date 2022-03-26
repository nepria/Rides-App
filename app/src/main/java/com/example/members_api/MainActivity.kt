package com.example.members_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.members_api.api.MemberService
import com.example.members_api.api.RetrofitHelper
import com.example.members_api.repository.MemberRepository
import com.example.members_api.viewmodel.MainViewModel
import com.example.members_api.viewmodel.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val memberService = RetrofitHelper.getInstance().create(MemberService::class.java)
//
//        val repository = MemberRepository(memberService)
//
//        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
//
//        mainViewModel.member.observe(this, Observer {
//            Log.d("Members are", it.toString())
//
//        })

    }
}