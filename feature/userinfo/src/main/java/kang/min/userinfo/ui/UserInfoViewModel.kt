package kang.min.userinfo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ifyouwant.domain.enumset.EnumGender
import ifyouwant.domain.usecase.userinfo.GetUserNameUseCase
import ifyouwant.domain.usecase.userinfo.SaveUserGenderUseCase
import ifyouwant.domain.usecase.userinfo.SaveUserNameUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val saveUserGenderUseCase: SaveUserGenderUseCase
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

    fun saveUserGender(gender: EnumGender) {
        viewModelScope.launch {
            saveUserGenderUseCase(gender)
        }
    }
}