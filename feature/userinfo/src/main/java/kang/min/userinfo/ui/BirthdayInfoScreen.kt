package kang.min.userinfo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kang.min.designsystem.IfYouWantTheme
import ifyouwant.justdo.ui.NumberPickerSpinner
import kang.min.userinfo.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayInfoScreen() {
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.img_birthday_cake),
            contentDescription = "생일 타이틀 이미지"
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(text = "생년월일을 선택해주세요", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "나이 : NN살", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { showBottomSheet = true }
            ) {
                Text(text = "선택하기")
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {

                NumberPickerSpinner(
                    modifier = Modifier.fillMaxWidth(),
                    items = (1..10).map { it.toString() },
                    startIndex = 3
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {
                        coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                            showBottomSheet = false
                        }
                    },
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(text = "선택")
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun BirthdayInfoScreenPreview() {
    IfYouWantTheme {
        BirthdayInfoScreen()
    }
}