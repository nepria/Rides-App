package com.example.members_api.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.members_api.model.Rides
import com.example.members_api.repository.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MemberRepository) : ViewModel(){
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMembers()
        }
    }
    val member: LiveData<Rides>
    get() = repository.member
}