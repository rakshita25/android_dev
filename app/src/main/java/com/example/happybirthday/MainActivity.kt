package com.example.happybirthday

//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                      GreetingImage(
                          message = stringResource(R.string.happy_birthday_text),
                          from = stringResource(R.string.from_text),
                          modifier = Modifier.padding(innerPadding)
                      )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Text(
            text = message,
            fontSize = 70.sp,
            lineHeight = 90.sp,
            modifier = modifier.padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 20.dp,
                    top = 30.dp,
                    bottom = 12.dp
                )
//                .align(alignment = Alignment.CenterHorizontally)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier = modifier
        .fillMaxSize()
        .padding(8.dp)){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.55F
        )
        GreetingText(
            message = message,
            from = from,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
//        GreetingText(message = "Happy Birthday Rue!", from = "From Emma")
        GreetingImage(
            message = "Happy Birthday Rue!",
            from = "From Emma",
            modifier = Modifier.padding(8.dp)
        )
    }
}