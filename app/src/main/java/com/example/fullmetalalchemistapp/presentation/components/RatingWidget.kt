package com.example.fullmetalalchemistapp.presentation.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fullmetalalchemistapp.R
import com.example.fullmetalalchemistapp.ui.theme.EXTRA_SMALL_PADDING
import com.example.fullmetalalchemistapp.ui.theme.Purple500
import com.example.fullmetalalchemistapp.util.Constants.MAX_RATING_NUMBER
import com.example.fullmetalalchemistapp.util.Constants.MAX_STARS_NUMBER

@Composable
fun RatingWidget(
    rating: Double,
    maxRating: Double = MAX_RATING_NUMBER,
    starFilledColor: Color,
    starUnfilledColor: Color = Color.LightGray.copy(alpha = 0.5f),
    scaleFactor: Float = 3f,
    spaceBetween: Dp = EXTRA_SMALL_PADDING,
    modifier: Modifier = Modifier
) {
    val result = calculateStars(
        rating = rating,
        maxRating = maxRating
    )

    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        // filled stars
        result["filledStars"]?.let {
            repeat(it) {
                FilledStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    starFilledColor = starFilledColor,
                    scaleFactor = scaleFactor
                )
            }
        }
        // half filled stars
        result["halfFilledStars"]?.let {
            repeat(it) {
                HalfFilledStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    starFilledColor = starFilledColor,
                    starUnfilledColor = starUnfilledColor,
                    scaleFactor = scaleFactor
                )
            }
        }
        // empty stars
        result["emptyStars"]?.let {
            repeat(it) {
                EmptyStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    starUnfilledColor = starUnfilledColor,
                    scaleFactor = scaleFactor
                )
            }
        }
    }
}

@Composable
fun FilledStar(
    starPath: Path,
    starPathBounds: Rect,
    starFilledColor: Color,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size

        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width - pathWidth) / 2.2f
            val top = (canvasSize.height - pathHeight) / 2.2f

            translate(
                left = left,
                top = top
            ) {
                drawPath(
                    path = starPath,
                    color = starFilledColor
                )
            }
        }
    }
}

@Composable
fun HalfFilledStar(
    starPath: Path,
    starPathBounds: Rect,
    starFilledColor: Color,
    starUnfilledColor: Color,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size

        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width - pathWidth) / 2.2f
            val top = (canvasSize.height - pathHeight) / 2.2f

            translate(
                left = left,
                top = top
            ) {
                drawPath(
                    path = starPath,
                    color = starUnfilledColor
                )
                clipPath(path = starPath) {
                    drawRect(
                        color = starFilledColor,
                        size = Size(
                            width = starPathBounds.maxDimension / 1.7f,
                            height = starPathBounds.maxDimension * scaleFactor
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyStar(
    starPath: Path,
    starPathBounds: Rect,
    starUnfilledColor: Color,
    scaleFactor: Float
) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val canvasSize = size

        scale(scale = scaleFactor) {
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width - pathWidth) / 2.2f
            val top = (canvasSize.height - pathHeight) / 2.2f

            translate(
                left = left,
                top = top
            ) {
                drawPath(
                    path = starPath,
                    color = starUnfilledColor
                )
            }
        }
    }
}

@Composable
fun calculateStars(
    rating: Double,
    maxRating: Double
): Map<String, Int> {
    val maxStars by remember { mutableStateOf(MAX_STARS_NUMBER) }
    var filledStars by remember { mutableStateOf(0) }
    var halfFilledStars by remember { mutableStateOf(0) }
    var emptyStars by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = rating) {
        if (rating in 0.0..maxRating) {
            val starsFill = rating * maxStars / maxRating
            filledStars = starsFill.toInt()
            if (starsFill - filledStars > 0.4995) {
                filledStars++
            } else {
                if (starsFill - filledStars > 0.0005) {
                    halfFilledStars++
                }
            }
        } else {
            Log.d("RatingWidget", "Invalid rating number.")
        }
        emptyStars = maxStars - filledStars - halfFilledStars
    }
    Log.d("RatingWidget", "filledStars: $filledStars")
    Log.d("RatingWidget", "halfFilledStars: $halfFilledStars")
    Log.d("RatingWidget", "emptyStars: $emptyStars")
    return mapOf(
        "filledStars" to filledStars,
        "halfFilledStars" to halfFilledStars,
        "emptyStars" to emptyStars,
    )
}

@Preview(showBackground = true)
@Composable
fun FilledStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

    FilledStar(
        starPath = starPath,
        starPathBounds = starPathBounds,
        starFilledColor = Purple500,
        scaleFactor = 3f
    )
}

@Preview(showBackground = true)
@Composable
fun HalfFilledStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

    HalfFilledStar(
        starPath = starPath,
        starPathBounds = starPathBounds,
        starFilledColor = Purple500,
        starUnfilledColor = Color.LightGray.copy(alpha = 0.5f),
        scaleFactor = 3f
    )
}

@Preview(showBackground = true)
@Composable
fun EmptyStarPreview() {
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

    EmptyStar(
        starPath = starPath,
        starPathBounds = starPathBounds,
        starUnfilledColor = Color.LightGray.copy(alpha = 0.5f),
        scaleFactor = 3f
    )
}