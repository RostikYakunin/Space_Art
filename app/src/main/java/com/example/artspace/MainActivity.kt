package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    val listMutableState = mutableStates()

    val painterRes = choosePainter(listMutableState.value[0])
    val decsRes = chooseDescription(listMutableState.value[1])
    val dateRes = chooseDate(listMutableState.value[2])

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEFBFF))
    ) {

        Wall(
            painter = painterRes,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .border(30.dp, Color(0xFFFEFBFF))
        )

        Description(
            description = decsRes,
            date = dateRes,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )

        Controller(
            prevButtonText = stringResource(R.string.button_prev),
            nextButtonText = stringResource(R.string.button_next),
            state = listMutableState,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

@Composable
private fun Wall(
    painter: Painter,
    modifier: Modifier = Modifier
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(horizontal = 50.dp)
            .shadow(20.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = modifier
                .size(300.dp, 400.dp)
        )
    }
}

@Composable
fun Description(
    description: String,
    date: String,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(300.dp, 100.dp)
            .background(Color(0xFFb48ead))
    ) {
        Text(
            text = description,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
        )

        Text(
            text = date,
            fontSize = 15.sp
        )
    }

}

@Composable
fun Controller(
    prevButtonText: String,
    nextButtonText: String,
    state: MutableState<List<Int>>,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth(1F)
    ) {

        Button(
            onClick = {
                val nextState =
                    if (state.value[0] != 1) state.value.map { it - 1 } else state.value.map { 6 }
                state.value = nextState
            }
        ) {
            Text(text = prevButtonText)
        }

        Button(
            onClick = {
                val nextState =
                    if (state.value[0] != 6) state.value.map { it + 1 } else state.value.map { 1 }
                state.value = nextState
            }
        ) {
            Text(text = nextButtonText)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ArtSpace()
        }
    }
}