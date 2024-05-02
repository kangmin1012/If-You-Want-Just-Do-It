package kang.min.todo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kang.min.designsystem.IfYouWantTheme

@Composable
fun TodoScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        TodoEmpty()
        WriteTodoFloating(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            // 작성 버튼
        }
    }
}

@Composable
private fun WriteTodoFloating(
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit = {}
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        onClick = { onClickButton() },
        icon = { Icon(Icons.Filled.Edit, "작성 버튼")},
        text = { Text(text = "Todo 작성") }
    )
}

@Composable
private fun TodoEmpty() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = R.drawable.baseline_hourglass_empty_24),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Todo가 없습니다.")
    }
}

@Composable
@Preview(showBackground = true)
private fun TodoScreenPreview() {
    IfYouWantTheme {
        TodoScreen()
    }
}

@Composable
@Preview(showBackground = true)
private fun WriteTodoFloatingPreview() {
    IfYouWantTheme {
        WriteTodoFloating()
    }
}

@Composable
@Preview(showBackground = true)
private fun TodoEmptyPreview() {
    IfYouWantTheme {
        TodoEmpty()
    }
}