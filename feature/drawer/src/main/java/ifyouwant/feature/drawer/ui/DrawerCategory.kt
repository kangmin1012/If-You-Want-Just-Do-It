package ifyouwant.feature.drawer.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ifyouwant.feature.drawer.navigation.DrawerDestination
import ifyouwant.feature.drawer.navigation.categoryTabs
import ifyouwant.justdo.ui.IfYouWantTheme

@Composable
fun DrawerCategoryList(
    items: List<DrawerDestination>,
    onItemClick: (route: String) -> Unit = {_ -> }
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "Drawer 메인 아이콘"
        )

        Spacer(modifier = Modifier.height(12.dp))

        items.forEach { drawerItem ->
            NavigationDrawerItem(
                label = { Text(text = drawerItem.title) },
                icon = { Icon(imageVector = drawerItem.icon, contentDescription = "Drawer 카테고리 탭 아이콘") },
                selected = false,
                onClick = {
                    onItemClick(drawerItem.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerCategoryListPreview() {
    IfYouWantTheme {
        DrawerCategoryList(categoryTabs)
    }
}