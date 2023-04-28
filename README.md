# Plot Compose
---

Make line charts and pie charts in Android Compose.

<img src="https://user-images.githubusercontent.com/52451860/235113777-f924d346-2927-45d8-8456-78d3f6c4ac81.png" width=100%>



[![](https://jitpack.io/v/Minecraftian14/PlotCompose.svg)](https://jitpack.io/#in.mcxiv/PlotCompose)
[![](https://img.shields.io/discord/872811194170347520?color=%237289da&logoColor=%23424549)](https://discord.gg/Ar6Zuj2m82)

## Setup

#### Gradle configurations

Add JitPack repository in `settings.gradle`
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // Other repos like google() or mavenCentral()
        
        // Jit Pack Repository
        maven { url 'https://jitpack.io/#in.mcxiv' }
    }
}
```

Add Plot Compose dependency in `app/build.gradle`
```
dependencies {
    // ... other dependencies

    // PlotCompose Dependency
    implementation 'in.mcxiv:PlotCompose:0.1'
}
```


#### Use it in a Composable

Create color schemes for themes
```kotlin
val colorScheme = ColorArrayChartColorScheme(
    listOf(
        Brush.radialGradient(0f to Color(0xFF0C9BD5), 1f to Color(0xFF00d3e7)),
        Brush.radialGradient(0f to Color(0xFF9336D1), 1f to Color(0xFF4a3097)),
        Brush.radialGradient(0f to Color(0xFF3496DB), 1f to Color(0xFF15599B)),
        Brush.radialGradient(0f to Color(0xFFff325f), 1f to Color(0xFFff9800)),
        Brush.radialGradient(0f to Color(0xFFff1b80), 1f to Color(0xFFAD058F)),
        Brush.radialGradient(0f to Color(0xFF109405), 1f to Color(0xFF59CA2F)),
    )
)
val baseColor =  Color(0xFF0C9BD5)
```

##### Pie Chart
```kotlin
PieChart(
    values = values,
    colorScheme = colorScheme,
    modifier = modifier.size(300.dp)
)
```
| Parameters          | Explanation                                                 |
| ------------------- | ----------------------------------------------------------- |
| values              | A `List<Float>` of the values to be plotted.                |
| colorScheme         | A `ChartColorScheme` to specify the colors used to fill.    |
| diskRadiusMinFactor | A `Float` to adjust the minimum radius a disklet can have.  |
| diskRadiusMaxFactor | A `Float` to adjust the maximum radius a disklet can have.  | 
| modifier            | A `Modifier` to customise how it's displayed in the UI.     |

##### Line Chart
```kotlin
LineChart(
    values = values,
    gradient = colorScheme,
    baseColor = baseColor,
    minimum = 14f,
    showMarkers = false,
    modifier = modifier.size(300.dp, 150.dp)
)
```
| Parameters  | Explanation                                                 |
| ----------- | ----------------------------------------------------------- |
| values      | A `List<Float>` of the values to be plotted.                |
| gradient    | A `Brush` used to fill the insides of the plot area.        |
| baseColor   | A `Color` used to draw the outline of the plot.             |
| minimum     | A `Float` value to truncate add a kink skipping values.     | 
| showMarkers | A `Boolean` to toggle the presence of the circular markers. |
| modifier    | A `Modifier` to customise how it's displayed in the UI.     |
