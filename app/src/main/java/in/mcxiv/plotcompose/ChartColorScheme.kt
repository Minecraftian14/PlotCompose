package `in`.mcxiv.plotcompose

import androidx.compose.ui.graphics.Brush

interface ChartColorScheme {
    fun reset()
    fun next(): Brush
    fun get(spin: Int): Brush
}