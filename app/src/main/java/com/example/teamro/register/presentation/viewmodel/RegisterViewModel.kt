package com.example.teamro.register.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teamro.register.domain.usecase.GetGoalUseCase
import com.example.teamro.register.presentation.model.Goal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getGoalUseCase: GetGoalUseCase
) : ViewModel() {
    private val _goals: MutableLiveData<MutableList<Goal>> = MutableLiveData()
    val goals: LiveData<MutableList<Goal>> get() = _goals
    private val _gender: MutableLiveData<String> = MutableLiveData()
    private val _goal: MutableLiveData<String> = MutableLiveData()
    private val _age: MutableLiveData<Int> = MutableLiveData()
    private val _allData: MutableLiveData<Boolean> = MutableLiveData()
    val allData: LiveData<Boolean> get() = _allData

    fun getGoals() {
        getGoalUseCase().observeForever {
            _goals.postValue(it)
        }
    }

    fun saveGender(gender: String) {
        _gender.postValue(gender)
    }

    fun saveGoal(goal: String) {
        _goal.postValue(goal)
    }

    fun saveAge(age: Int) {
        _age.postValue(age)
    }

    fun saveAllData() {

        _allData.postValue(_gender.value != null && _goal.value != null && _age.value != null)
    }
}
