package kang.min.userinfo.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ifyouwant.domain.usecase.userinfo.GetUserNameUseCase
import ifyouwant.domain.usecase.userinfo.SaveUserNameUseCase
import kang.min.userinfo.ui.GenderScreen
import kang.min.userinfo.ui.UserInfoScreen
import kang.min.userinfo.ui.UserInfoViewModel

interface UserInfoDestination {
    val route: String
}

object UserInfoRoute : UserInfoDestination {
    override val route: String
        get() = "user_info"
}

internal object UserName : UserInfoDestination {
    override val route: String
        get() = "user_name"
}

internal object GenderInfo : UserInfoDestination {
    override val route: String
        get() = "gender_info"
}
