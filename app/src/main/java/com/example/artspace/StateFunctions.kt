package com.example.artspace

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
internal fun mutableStates(
    state: Int = 1
): MutableState<List<Int>> {
    return remember { mutableStateOf(listOf(state, state, state)) }
}

@Composable
internal fun choosePainter(image: Int): Painter {
    return when (image) {
        1 -> painterResource(R.drawable.__park)
        2 -> painterResource(R.drawable.__pool)
        3 -> painterResource(R.drawable.__stadium)
        4 -> painterResource(R.drawable.__event)
        5 -> painterResource(R.drawable.__beach)
        6 -> painterResource(R.drawable.__mosque)
        else -> painterResource(R.drawable.__park)
    }
}

@Composable
internal fun chooseDescription(description: Int): String {
    return when (description) {
        1 -> stringResource(R.string.park_title)
        2 -> stringResource(R.string.pool_title)
        3 -> stringResource(R.string.stadium_title)
        4 -> stringResource(R.string.event_title)
        5 -> stringResource(R.string.beach_title)
        6 -> stringResource(R.string.mosque_title)
        else -> stringResource(R.string.park_title)
    }
}

@Composable
internal fun chooseDate(date: Int): String {
    return when (date) {
        1 -> stringResource(R.string.park_date)
        2 -> stringResource(R.string.pool_date)
        3 -> stringResource(R.string.stadium_date)
        4 -> stringResource(R.string.event_date)
        5 -> stringResource(R.string.beach_date)
        6 -> stringResource(R.string.mosque_date)
        else -> stringResource(R.string.park_date)
    }
}