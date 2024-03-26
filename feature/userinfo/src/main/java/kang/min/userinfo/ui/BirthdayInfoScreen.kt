package kang.min.userinfo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ifyouwant.justdo.ui.IfYouWantTheme
import kang.min.userinfo.R

@Composable
fun BirthdayInfoScreen() {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.align(Alignment.TopCenter).padding(top = 100.dp),
            painter = painterResource(id = R.drawable.img_birthday_cake),
            contentDescription = "생일 타이틀 이미지"
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "생년월일을 선택해주세요", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "나이 : NN살", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { }
            ) {
                Text(text = "선택하기")
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun BirthdayInfoScreenPreview() {
    IfYouWantTheme {
        BirthdayInfoScreen()
    }
}