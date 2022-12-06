package com.example.teamro.dashboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teamro.dashboard.domain.usecase.GetDataUserUseCase
import com.example.teamro.dashboard.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getDataUserCase: GetDataUserUseCase
) : ViewModel() {
    private val _datUser: MutableLiveData<MutableList<User>> = MutableLiveData()
    val dataUser: LiveData<MutableList<User>> get() = _datUser

    fun getDataUser() {
        getDataUserCase().observeForever {
            _datUser.postValue(it)
        }
    }
}