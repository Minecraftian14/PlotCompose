package `in`.mcxiv.plotcompose

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import kotlin.math.max
import kotlin.math.min

@Composable
fun PieChart(
    values: List<Float>,
    colorScheme: ChartColorScheme,
    diskRadiusMinFactor: Float = 0.7f,
    diskRadiusMaxFactor: Float = 1.0f,
    modifier: Modifier
) {
    val diskRadiusRangeFactor = diskRadiusMaxFactor - diskRadiusMinFactor
    val sumOfValues = values.reduce { a, b -> a + b }
    val minOfValues = values.reduce(::min)
    val maxOfValues = values.reduce(::max)
    val rangeOfValues = maxOfValues - minOfValues
    val degrees = values.map { (it * 360f) / sumOfValues }
    val cumulativeDegrees = degrees.indices.map { ub ->
        if (ub == 0) 0f else (0 until ub).map { i -> degrees[i] }.reduce { a, b -> a + b }
    }
    colorScheme.reset()

    Canvas(modifier = modifier) {
        val shadowDiameter = size.width * (diskRadiusMinFactor + diskRadiusMaxFactor) / 2

        degrees.indices.forEach {
            val diameter =
                size.width * (diskRadiusMinFactor
                        + diskRadiusRangeFactor * (values[it] - minOfValues) / rangeOfValues)
            val offset = (size.width - diameter) / 2
            val actualShadowDiameter = min(diameter, shadowDiameter)
            val shadowOffset = (size.width - actualShadowDiameter) / 2
            drawArc(
                brush = colorScheme.next(),
                startAngle = cumulativeDegrees[it],
                sweepAngle = degrees[it],
                useCenter = true,
                topLeft = Offset(offset, offset),
                size = Size(diameter, diameter)
            )
            drawArc(
                color = Color(0x0D000000),
                cumulativeDegrees[it],
                degrees[it],
                true,
                topLeft = Offset(shadowOffset, shadowOffset),
                Size(actualShadowDiameter, actualShadowDiameter)
            )
        }
        drawCircle(
            color = Color.Black, alpha = 0.1f,
            radius = size.width * 0.14f,
        )
        drawCircle(
            color = Color.White, alpha = 0.5f,
            radius = size.width * 0.12f,
        )
        drawCircle(
            color = Color.White, alpha = 0.6f,
            radius = size.width * 0.1f,
        )
    }
}