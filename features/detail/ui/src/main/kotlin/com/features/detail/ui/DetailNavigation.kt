package com.features.detail.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ibrahimkurt.core.ui.extensions.navigateTopSingle

data class DetailNavActions(
    val navigateToBack: () -> Unit
)

fun NavController.navigateToDetail(
    id: Int,
    navOptions: NavOptions? = null
) {
    navigateTopSingle("detail/$id", navOptions)
}

fun NavGraphBuilder.detail(detailNavActions: DetailNavActions) {
    composable(
        route = "detail/{id}",
        arguments = listOf(
            navArgument("id") {
                type = NavType.IntType
            }
        )
    ) {
        DetailRoute(detailNavActions = detailNavActions)
    }
}