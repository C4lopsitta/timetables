package dev.robaldo.timetables

actual object Logger {
    actual fun error(message: String, tag: String) { kotlin.io.println(message) }
    actual fun warn(message: String, tag: String) { kotlin.io.println(message) }
    actual fun info(message: String, tag: String) { kotlin.io.println(message) }
    actual fun debug(message: String, tag: String) { kotlin.io.println(message) }
}