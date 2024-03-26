package kang.min.userinfo.ui

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ifyouwant.justdo.ui.util.Keyboard
import ifyouwant.justdo.ui.util.keyboardAsState
import kang.min.userinfo.navigation.GenderInfo
import kang.min.userinfo.navigation.UserName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoScreen(
    userInfoViewModel: UserInfoViewModel = hiltViewModel(),
    onClickFinish: () -> Unit = {},
    onClickClose: () -> Unit = {}
) {
    val navController = rememberNavController()
    val focusManager = LocalFocusManager.current
    val userName by userInfoViewModel.userNameState.collectAsState()
    val keyboardState by keyboardAsState()

    if (keyboardState == Keyboard.Closed) {
        focusManager.clearFocus()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (navController.currentDestination?.route == UserName.route) {
                                onClickClose()
                            } else {
                                navController.popBackStack()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
                title = { }
            )
        }
    ) {

        NavHost(
            navController = navController,
            startDestination = UserName.route,
            modifier = Modifier.padding(it)
        ) {

            composable(UserName.route) {
                UserNameScreen(
                    userName = userName,
                    onClickSaveName = { userName ->
                        userInfoViewModel.saveUserName(userName = userName)

                        navController.navigate(GenderInfo.route) {
                            popUpTo(UserName.route) {
                                saveState = true
                            }

                            restoreState = true
                        }
                    }
                )
            }

            composable(GenderInfo.route) {
                GenderScreen(
                    onSuccessSaveGender = onClickFinish
                )
            }
        }
    }
}