package kang.min.userinfo.ui

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor() : ViewModel() {

    private val _userNameState = MutableStateFlow("")
    val userNameState = _userNameState.asStateFlow()


}