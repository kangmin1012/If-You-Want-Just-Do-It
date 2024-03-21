package ifyouwant.data.datasource

import ifyouwant.data.datastore.UserInfoDataStore
import javax.inject.Inject

class UserInfoDataSource @Inject constructor(
    private val userInfoDataStore: UserInfoDataStore
) {
    fun getUserNameFlow() = userInfoDataStore.userNameFlow
}