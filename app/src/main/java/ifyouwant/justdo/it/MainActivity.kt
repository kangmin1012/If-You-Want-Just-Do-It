package ifyouwant.justdo.it

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ifyouwant.justdo.it.navigation.MainRoute
import ifyouwant.justdo.it.ui.MainScreen
import ifyouwant.justdo.ui.IfYouWantTheme
import kang.min.userinfo.navigation.UserInfoRoute
import kang.min.userinfo.navigation.nestedUserInfoGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IfYouWantTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme

                Scaffold {
                    NavHost(
                        navController = navController,
                        startDestination = MainRoute.route,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(MainRoute.route) {
                            MainScreen(
                                onClickUserInfoButton = {
                                    navController.navigate(UserInfoRoute.route)
                                }
                            )
                        }
                        nestedUserInfoGraph(
                            navController = navController,
                            onFinishUserInfoSetting = {
                                navController.navigate(MainRoute.route) {
                                    launchSingleTop = true
                                    popUpTo(MainRoute.route) { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}