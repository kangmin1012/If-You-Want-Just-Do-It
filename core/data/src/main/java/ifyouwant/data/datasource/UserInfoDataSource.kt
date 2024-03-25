package ifyouwant.data.datasource

import ifyouwant.data.datastore.UserInfoDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInfoDataSource @Inject constructor(
    private val userInfoDataStore: UserInfoDataStore
) {
    fun getUserNameFlow() = userInfoDataStore.userNameFlow

    suspend fun saveUserName(name: String) = withContext(Dispatchers.IO) {
        userInfoDataStore.saveUserName(name)
    }

    suspend fun saveUserGender(state: Int) = withContext(Dispatchers.IO) {
        userInfoDataStore.saveUserGender(state)
    }
}