package dev.robaldo.timetables

import android.util.Log

actual object Logger {
    actual fun error(message: String, tag: String) { Log.e(tag, message) }
    actual fun warn(message: String, tag: String) { Log.w(tag, message) }
    actual fun info(message: String, tag: String) { Log.i(tag, message) }
    actual fun debug(message: String, tag: String) { Log.d(tag, message) }
}