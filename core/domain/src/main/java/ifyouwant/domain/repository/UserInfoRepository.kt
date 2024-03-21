package ifyouwant.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserInfoRepository {
    fun getUserName(): Flow<String>
}