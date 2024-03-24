package kang.min.userinfo.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ifyouwant.justdo.ui.IfYouWantTheme
import kang.min.userinfo.ui.enumset.EnumGender

@Composable
fun GenderScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GenderScreenContainer()
    }
}

@Composable
private fun GenderScreenContainer() {
    var state by remember { mutableStateOf(EnumGender.NONE) }

    Box(
        modifier = Modifier.fillMaxSize().padding(top = 100.dp, bottom = 32.dp)
    ) {

        Column(
            modifier = Modifier.align(Alignment.TopCenter).padding(horizontal = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "성별을 선택해주세요",
                style = MaterialTheme.typography.headlineMedium
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 64.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                GenderRadioButton(
                    modifier = Modifier.weight(1f, true),
                    isSelected = state == EnumGender.MAN,
                    genderString = "남자"
                ) {
                    state = EnumGender.MAN
                }
                GenderRadioButton(
                    modifier = Modifier.weight(1f, true),
                    isSelected = state == EnumGender.WOMAN,
                    genderString = "여자"
                ) {
                    state = EnumGender.WOMAN
                }
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter),
            onClick = {

            },
            contentPadding = PaddingValues(18.dp)
        ) {
            Text(text = "결정", style = MaterialTheme.typography.bodyLarge)
        }
    }

}

@Composable
private fun GenderRadioButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    genderString: String = "남자",
    onSelect: () -> Unit
) {

    val borderColor = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        Color.Gray
    }

    val containerColor = if (isSelected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        Color.White
    }

    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimaryContainer
    } else {
        Color.Gray
    }

    OutlinedButton(
        modifier = modifier,
        onClick = { onSelect() },
        border = BorderStroke(
            2.dp,
            borderColor
        ),
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = textColor,
            disabledContentColor = containerColor,
            disabledContainerColor = textColor
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(text = genderString)
    }
}

@Preview(showBackground = true)
@Composable
fun GenderScreenPreview() {
    IfYouWantTheme {
        GenderScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GenderRadioButtonPreview() {
    IfYouWantTheme {
        GenderRadioButton() { }
    }
}