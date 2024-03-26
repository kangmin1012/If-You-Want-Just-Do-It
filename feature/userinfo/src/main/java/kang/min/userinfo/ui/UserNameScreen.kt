package kang.min.userinfo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ifyouwant.justdo.ui.IfYouWantTheme

@Composable
internal fun UserNameScreen(
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