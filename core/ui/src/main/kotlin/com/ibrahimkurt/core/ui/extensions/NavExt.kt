package com.ibrahimkurt.core.ui.extensions

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavHostController.navigateReorderBackStack(route: String) {
    this@navigateReorderBackStack.navigate(route) {
        launchSingleTop = true
        popUpTo(this@navigateReorderBackStack.graph.findStartDestination().id) {
            saveState = true
        }
        restoreState = true
    }
}

fun NavController.navigateTopSingle(
    route: String,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val defaultNavOptionsBuilder = NavOptions.Builder()
        .setLaunchSingleTop(true)
    navOptions?.let { userNavOptions ->
        defaultNavOptionsBuilder.apply {
            setEnterAnim(userNavOptions.enterAnim)
            setExitAnim(userNavOptions.exitAnim)
            setPopEnterAnim(userNavOptions.popEnterAnim)
            setPopExitAnim(userNavOptions.popExitAnim)
            setPopUpTo(userNavOptions.popUpToId, userNavOptions.isPopUpToInclusive())
        }
    }
    return navigate(route, defaultNavOptionsBuilder.build(), navigatorExtras)
}