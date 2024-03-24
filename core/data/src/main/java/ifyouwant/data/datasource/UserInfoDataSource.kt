package ifyouwant.data.datasource

import ifyouwant.data.datastore.UserInfoDataStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInfoDataSource @Inject constructor(
    private val userInfoDataStore: UserInfoDataStore
) {
    fun getUserNameFlow() = userInfoDataStore.userNameFlow

    suspend fun saveUserName(name: String) {
        userInfoDataStore.saveUserName(name)
    }
}