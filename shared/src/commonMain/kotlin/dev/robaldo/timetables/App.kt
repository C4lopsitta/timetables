package dev.robaldo.timetables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import cloud.elemento.electros.ui.WindowSizing
import cloud.elemento.electros.ui.toLayoutSize
import dev.robaldo.timetables.routes.AppRoute
import dev.robaldo.timetables.routes.AppRouteGraph
import dev.robaldo.timetables.ui.components.navigation.BottomBar
import dev.robaldo.viaggiatreno.ViaggiaTreno
import io.ktor.client.HttpClient

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    val windowSizeClass = currentWindowAdaptiveInfo(
        supportLargeAndXLargeWidth = true
    ).windowSizeClass

    val client = HttpClient()
    val vtc = ViaggiaTreno(client)

    MaterialTheme {

        Scaffold (
            bottomBar = {
                if (windowSizeClass.toLayoutSize() == WindowSizing.Small) {
                    BottomBar(
                        currentRouteState = navController.currentBackStackEntryAsState(),
                        navigate = { navController.navigate(it) }
                    )
                }
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = AppRouteGraph,
                modifier = Modifier
                    .padding(it)
                    .padding( horizontal = 12.dp )
                    .fillMaxSize()
            ) {
                navigation<AppRouteGraph>(startDestination = AppRoute.Departures) {
                    composable<AppRoute.Departures> {
                        Text("Departures")
                    }

                    composable<AppRoute.Arrivals> {
                        Text("Arrivals")
                    }

                    composable<AppRoute.Search> {
                        Text("Search")
                    }
                }
            }
        }

    }
}
