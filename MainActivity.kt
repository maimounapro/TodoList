package com.example.liste

import android.graphics.drawable.Icon
import android.icu.text.ListFormatter.Width
import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.liste.ui.theme.ListeTheme
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            titre()
            todo()
        }
    }
}
@Composable
@Preview
fun titre(){

        Row(modifier = Modifier
            .background(Color.Magenta)
            .padding(15.dp)
            .fillMaxWidth(),
        ){
            Text(text="MY TO DO LIST",textAlign = TextAlign.Center, fontSize = 28.sp)

        }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun todo() {
    var tasks by remember { mutableStateOf("") }
    val tasklist = remember { mutableStateListOf<String>("etudier","manger","dormir") }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(80.dp)
    ){
        TextField(value = tasks, onValueChange = { tasks = it })
        Button(onClick = { tasklist.add(tasks) },
            modifier= Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
            Text("add a task")
        }
        LazyColumn{
            items(items = tasklist){
                task->Text(""+task, fontSize = 20.sp, fontFamily = FontFamily.Serif)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun displayList(){
    todo()
}