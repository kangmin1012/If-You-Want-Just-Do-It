package ifyouwant.feature.drawer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ifyouwant.feature.drawer.navigation.About
import ifyouwant.feature.drawer.navigation.Articles
import ifyouwant.feature.drawer.navigation.Settings
import ifyouwant.feature.drawer.navigation.categoryTabs
import ifyouwant.justdo.ui.IfYouWantTheme
import ifyouwant.justdo.ui.navigator.navigateSingleTopTo
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScreen(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
) {
    val coroutineScope = rememberCoroutineScope()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentScreen =
        categoryTabs.findLast { it.route == currentBackStack?.destination?.route } ?: Articles

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerCategoryList(items = categoryTabs) { route ->
                    coroutineScope.launch {
                        drawerState.close()
                    }

                    navController.navigateSingleTopTo(route)
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Drawer 표시 아이콘")
                        }
                    },
                    title = { Text(text = currentScreen.title) }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                NavHost(navController = navController, startDestination = Articles.route) {
                    composable(Articles.route) {
                        ArticlesScreen()
                    }

                    composable(About.route) {
                        AboutScreen()
                    }

                    composable(Settings.route) {
                        SettingsScreen()
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun DrawerScreenPreview() {
    IfYouWantTheme {
        DrawerScreen()
    }
}