package com.example.teamro.dashboard.domain.usecase

import com.example.teamro.dashboard.domain.repository.DashboardRepository
import javax.inject.Inject

class GetDataUserUseCase @Inject constructor(private val dashboardRepository: DashboardRepository) {
    operator fun invoke() = dashboardRepository.getUserData()
}