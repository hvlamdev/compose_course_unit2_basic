package com.vanlam.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanlam.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {
    var currentIndex by remember { mutableStateOf(0) }
    var state = listOf<Map<String, Int>>(
        mapOf(
            "image" to R.drawable.lemon_tree,
            "text" to R.string.lemon_tree
        ),
        mapOf(
            "image" to R.drawable.lemon_squeeze,
            "text" to R.string.lemon
        ),
        mapOf(
            "image" to R.drawable.lemon_drink,
            "text" to R.string.glass_of_lemonade
        ), mapOf(
            "image" to R.drawable.lemon_restart,
            "text" to R.string.empty_glass
        )
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                stringResource(state[currentIndex]["text"]!!),
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Image(
                painter = painterResource(id = state[currentIndex]["image"]!!),
                contentDescription = "drink",
                Modifier
                    .border(width = 2.dp, Color(105, 205, 216), shape = RoundedCornerShape(4.dp))
                    .padding(16.dp)
                    .clickable {
                        currentIndex++
                        if (currentIndex >= state.size) {
                            currentIndex = 0
                        }
                    }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonApp()
}