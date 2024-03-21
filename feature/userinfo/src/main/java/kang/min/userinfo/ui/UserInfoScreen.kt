package kang.min.userinfo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ifyouwant.justdo.ui.IfYouWantTheme

@Composable
fun UserInfoScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("당신의 이름이 무엇인가요?")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserInfoScreenPreview() {
    IfYouWantTheme {
        UserInfoScreen()
    }
}