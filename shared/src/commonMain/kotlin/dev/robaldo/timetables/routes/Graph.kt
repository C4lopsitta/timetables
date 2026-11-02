package dev.robaldo.timetables.routes

import kotlinx.serialization.Serializable

@Serializable data object AppRouteGraph
@Serializable sealed interface AppRoute {
    @Serializable data object Departures: AppRoute
    @Serializable data object Arrivals: AppRoute
    @Serializable data object Search: AppRoute
    @Serializable data object Trips: AppRoute
    @Serializable data object Settings: AppRoute
}
