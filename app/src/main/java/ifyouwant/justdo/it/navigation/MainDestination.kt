package ifyouwant.justdo.it.navigation

interface MainDestination {
    val route: String
}

object MainRoute: MainDestination {
    override val route: String
        get() = "main"
}