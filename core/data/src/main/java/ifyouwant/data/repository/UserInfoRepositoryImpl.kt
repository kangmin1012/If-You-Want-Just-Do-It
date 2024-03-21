package ifyouwant.data.repository

import ifyouwant.data.datasource.UserInfoDataSource
import ifyouwant.domain.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val userInfoDataStore: UserInfoDataSource
) : UserInfoRepository {
    override fun getUserName(): Flow<String> = userInfoDataStore.getUserNameFlow()

    override suspend fun saveUserName(userName: String) {
        userInfoDataStore.saveUserName(userName)
    }
}