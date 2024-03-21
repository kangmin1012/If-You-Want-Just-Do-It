package kang.min.userinfo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ifyouwant.justdo.ui.IfYouWantTheme
import ifyouwant.justdo.ui.util.Keyboard
import ifyouwant.justdo.ui.util.keyboardAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInfoScreen(
    userInfoViewModel: UserInfoViewModel = hiltViewModel()
) {
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
                        onClick = { }
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
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            UserNameScreen(userName) { name ->
                userInfoViewModel.saveUserName(name)
            }
        }
    }

}

@Composable
private fun UserNameScreen(
    userName: String = "",
    onClickSaveName: (name: String) -> Unit = {}
) {

    var textFieldUserName by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            if (userName.isBlank())
                "당신의 이름은 무엇인가요?"
            else
                "${userName}님 반가워요~"
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            label = {
                Text(text = "이름")
            },
            value = textFieldUserName,
            onValueChange = {
                textFieldUserName = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onClickSaveName(textFieldUserName) }
        ) {
            Text(text = "이름 저장하기")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserNameScreenPreview() {
    IfYouWantTheme {
        UserNameScreen("홍길동")
    }
}