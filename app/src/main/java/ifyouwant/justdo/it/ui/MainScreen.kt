package ifyouwant.justdo.it.ui

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ifyouwant.feature.drawer.DrawerActivity
import kang.min.designsystem.IfYouWantTheme

@Composable
fun MainScreen(
    onClickUserInfoButton: () -> Unit = {}
) {
    val context = LocalContext.current

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    context.startActivity(Intent(context, DrawerActivity::class.java))
                }
            ) {
                Text(text = "Open Drawer Sample Activity")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onClickUserInfoButton
            ) {
                Text(text = "Open User Info")
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    IfYouWantTheme {
        MainScreen()
    }
}