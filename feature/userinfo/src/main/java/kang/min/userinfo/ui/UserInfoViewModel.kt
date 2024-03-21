package kang.min.userinfo.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ifyouwant.domain.usecase.GetUserNameUseCase
import ifyouwant.domain.usecase.SaveUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    val userNameState = getUserNameUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        ""
    )


    fun saveUserName(userName: String) {
        viewModelScope.launch {
            saveUserNameUseCase(userName)
        }
    }
}