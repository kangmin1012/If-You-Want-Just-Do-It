package ifyouwant.justdo.it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import ifyouwant.justdo.it.ui.MainScreen
import ifyouwant.justdo.ui.IfYouWantTheme
import kang.min.userinfo.ui.GenderScreen
import kang.min.userinfo.ui.UserInfoScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IfYouWantTheme {
                // A surface container using the 'background' color from the theme
//                MainScreen()

//                UserInfoScreen()
                GenderScreen()
            }
        }
    }
}