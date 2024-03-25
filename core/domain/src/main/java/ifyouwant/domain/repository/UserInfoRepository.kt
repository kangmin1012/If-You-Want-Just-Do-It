package ifyouwant.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserInfoRepository {
    fun getUserName(): Flow<String>

    suspend fun saveUserName(userName: String)

    suspend fun saveUserGender(state: Int)
}