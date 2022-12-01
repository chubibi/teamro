package com.example.teamro.register.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamro.register.domain.usecase.GetGoalUseCase
import com.example.teamro.register.presentation.model.Goal
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val getGoalUseCase: GetGoalUseCase
) : ViewModel() {
    private val _goals: MutableLiveData<MutableList<Goal>> = MutableLiveData()
    val goals: LiveData<MutableList<Goal>> get() = _goals

    fun getGoals() {
        viewModelScope.launch { }
    }
}
