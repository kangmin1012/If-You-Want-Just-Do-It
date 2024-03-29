package ifyouwant.data.datastore

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserInfoDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val Context.dataStore by preferencesDataStore(name = USER_INFO_PREFERENCES)

    companion object {
        const val USER_INFO_PREFERENCES = "user_info_preferences"
    }

    private val keyUserName = stringPreferencesKey("user_name")

    val userNameFlow = context.dataStore.data.map { preference ->
        preference[keyUserName] ?: ""
    }

    suspend fun saveUserName(userName: String) {
        context.dataStore.edit { preference ->
            preference[keyUserName] = userName
        }
    }

    private val keyUserGender = intPreferencesKey("user_gender")

    suspend fun saveUserGender(state: Int) {
        context.dataStore.edit { preference ->
            preference[keyUserGender] = state
        }
    }
}