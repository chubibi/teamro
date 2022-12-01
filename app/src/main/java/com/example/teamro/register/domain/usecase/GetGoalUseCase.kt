package com.example.teamro.register.domain.usecase

import com.example.teamro.register.domain.repository.GoalRepository
import javax.inject.Inject

class GetGoalUseCase @Inject constructor(private val goalRepository: GoalRepository)
