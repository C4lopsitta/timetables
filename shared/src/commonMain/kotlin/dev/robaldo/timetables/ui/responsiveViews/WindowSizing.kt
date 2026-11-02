package cloud.elemento.electros.ui

import androidx.window.core.layout.WindowSizeClass

enum class WindowSizing {
    Small,
    Medium,
    Large
}

fun WindowSizeClass.toLayoutSize(): WindowSizing =
    when {
        isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND
        ) -> WindowSizing.Large

        isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND
        ) -> WindowSizing.Medium

        else -> WindowSizing.Small
    }
