package dev.robaldo.timetables

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform