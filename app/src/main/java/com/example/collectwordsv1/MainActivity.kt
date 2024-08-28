package com.example.collectwordsv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.collectwordsv1.ui.theme.CollectWordsV1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CollectWordsV1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->



                            CollectWordsV1App(modifier = Modifier.padding(innerPadding))



                }
            }
        }
    }
}
@Composable
fun CollectWordsV1App(modifier: Modifier = Modifier) {
    var word by remember { mutableStateOf("") }
    var words = remember { mutableStateListOf<String>() }
    var diplay by remember { mutableStateOf("") }
Column(modifier = modifier) {
    Text(text ="Collect Word")
    OutlinedTextField(value = word, onValueChange ={word =it},
        keyboardOptions = KeyboardOptions.Default,
        label = { Text("Word") })
    Row {
        Button(onClick = { words.add(word) }) {
            Text("Add")
        }
        Button(onClick = { words.clear() }) {
            Text("Clear")
        }

        Button(onClick = { diplay= words.joinToString(",") }) {
            Text(text = "Show")
        }
    }
    Text(text ="Word:$diplay")
    }
}

@Preview()
@Composable
fun CollectWordsV1AppPreview() {
    CollectWordsV1Theme {
        CollectWordsV1App()
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview()
@Composable
fun GreetingPreview() {
    CollectWordsV1Theme {
        Greeting("Android")
    }
}