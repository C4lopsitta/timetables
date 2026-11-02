package dev.robaldo.timetables

expect object Logger {
    fun error(message: String, tag: String)
    fun warn(message: String, tag: String)
    fun info(message: String, tag: String)
    fun debug(message: String, tag: String)
}