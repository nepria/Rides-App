package com.example.members_api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.members_api.api.MemberService
import com.example.members_api.api.RetrofitHelper
import com.example.members_api.model.Rides

class MemberRepository(private val memberService: MemberService) {
    private val memberLiveData = MutableLiveData<Rides>()
     val member: LiveData<Rides>
     get() = memberLiveData

     suspend fun getMembers() {
         val result =  RetrofitHelper.api.getMembers()
         when {
             result.body() != null -> {
                 memberLiveData.postValue(result.body())
             }
         }
     }
}

