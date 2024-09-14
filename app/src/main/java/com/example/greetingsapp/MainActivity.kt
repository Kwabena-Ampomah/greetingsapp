package com.example.greetingsapp
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.greetingsapp.ui.theme.GreetingsappTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import java.text.SimpleDateFormat
import java.util.Calendar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingsappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting()

                }
            }
        }
    }
}
@SuppressLint("SimpleDateFormat")
@Preview
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Greeting() {
    var yourname by remember { mutableStateOf("") }
    var idk by remember { mutableStateOf("") }
    val  calendar = Calendar.getInstance()
    val exact= SimpleDateFormat("HH").format(calendar.time).toInt()


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,) {
        TextField(
            value = yourname,
            onValueChange = { yourname = it },
            label = { Text("Whats your name") },
            )
        Button(onClick = {
            idk  = if (exact < 12){
                "Good morning  $yourname"
            } else if (exact in 12..15){
                "Good afternoon  $yourname"
            } else if (exact in 15..18){
                "Good evening  $yourname"
            } else{
                "Good night  $yourname"
            }
        })
        {
            Text("Greet")
        }
        Text(text= idk)





    }

}