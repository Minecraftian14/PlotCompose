package `in`.mcxiv.plotcompose

import androidx.compose.ui.graphics.Brush

class ColorArrayChartColorScheme(private val colors: List<Brush>) : ChartColorScheme {

    private var idx = 0

    override fun reset() {
        idx = 0
    }

    override fun next(): Brush {
        val i = idx
        idx = (++idx) % colors.size
        return colors[i]
    }

    override fun get(spin: Int): Brush {
        return colors[spin % colors.size]
    }
}