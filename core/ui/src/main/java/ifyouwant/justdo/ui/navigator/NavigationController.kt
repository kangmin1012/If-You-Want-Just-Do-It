package ifyouwant.justdo.ui.navigator

import androidx.navigation.NavHostController

fun NavHostController.navigateSingleTopTo(rout: String) {
    this.navigate(rout) {
        launchSingleTop = true // 백 스택에 대상이 최대 1개만 존재하도록 설정
        popUpTo(
            this@navigateSingleTopTo.graph.startDestinationId // 백스택을 맨 처음 대상까지 popUp
        ) {
            saveState = true // popup 하는 대상의 상태를 저장하고 있을 것인지 여부
        }

        restoreState = true // 대상의 이전 상태를 다시 불러 들일건지 여부
    }
}
