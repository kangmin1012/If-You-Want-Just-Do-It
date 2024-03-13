package ifyouwant.feature.drawer.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface DrawerDestination {
    val icon: ImageVector
    val route: String
    val title: String
}

object Articles : DrawerDestination {
    override val icon: ImageVector
        get() = Icons.Filled.AccountCircle
    override val route: String
        get() = "articles"

    override val title: String
        get() = "Articles"
}

object About : DrawerDestination {
    override val icon: ImageVector
        get() = Icons.Filled.MoreVert

    override val route: String
        get() = "about"

    override val title: String
        get() = "About"
}

object Settings : DrawerDestination {
    override val icon: ImageVector
        get() = Icons.Filled.Settings

    override val route: String
        get() = "settings"

    override val title: String
        get() = "Settings"
}

val categoryTabs = listOf(
    Articles,
    About,
    Settings
)