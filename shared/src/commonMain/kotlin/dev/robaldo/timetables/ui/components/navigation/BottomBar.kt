package dev.robaldo.timetables.ui.components.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.toRoute
import dev.robaldo.timetables.routes.AppRoute


private fun NavBackStackEntry.appRouteOrNull(): AppRoute? =
    runCatching { toRoute<AppRoute>() }.getOrNull()

@Composable
fun BottomBar(
    currentRouteState: State<NavBackStackEntry?>,
    navigate: (AppRoute) -> Unit
) {
    val currentRoute by currentRouteState

    NavigationBar (

    ) {
        NavigationBarItem(
            selected = AppRoute.Departures == currentRoute?.appRouteOrNull(),
            onClick = { navigate(AppRoute.Departures) },
            icon = {},
            label = { Text("Departures") }
        )

        NavigationBarItem(
            selected = AppRoute.Arrivals == currentRoute?.appRouteOrNull(),
            onClick = { navigate(AppRoute.Arrivals) },
            icon = {},
            label = { Text("Arrivals") }
        )

        NavigationBarItem(
            selected = AppRoute.Search == currentRoute?.appRouteOrNull(),
            onClick = { navigate(AppRoute.Search) },
            icon = {},
            label = { Text("Search") }
        )

        NavigationBarItem(
            selected = AppRoute.Trips == currentRoute?.appRouteOrNull(),
            onClick = { navigate(AppRoute.Trips) },
            icon = {},
            label = { Text("Trips") }
        )

        NavigationBarItem(
            selected = AppRoute.Settings == currentRoute?.appRouteOrNull(),
            onClick = { navigate(AppRoute.Settings) },
            icon = {},
            label = { Text("Settings") }
        )
    }
}
