package com.example.turnolab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.turnolab2.ui.theme.TurnoLab2Theme
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.turnolab2.ui.theme.Purple40
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableIntStateOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TurnoLab2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(name = "Android", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// preview only in Android Studio, not on phone
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TurnoLab2Theme { Greeting("Android") }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // Column = vertical layout
    Column(
        modifier = modifier.fillMaxSize().background(Color.White).padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // round avatar with purple border
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Avatar Logo",
            modifier = Modifier
                .fillMaxWidth(fraction = 0.3f)
                .clip(CircleShape)
                .padding(bottom = 16.dp)
                .border(width = 2.dp, color = Purple40, shape = CircleShape)
        )

        Text("Kyle Tristan D. Turno", fontWeight = FontWeight.Bold, color = Color.Black)

        Text(
            "BSIT Student | Mobile Developer",
            color = Color.Gray,
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Row = horizontal layout
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon", tint = Purple40, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(5.dp))
            Text("kyletristanturno2005@gmail.com", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = "Phone Icon", tint = Purple40, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(5.dp))
            Text("+63 915 6006 472", color = Color.Black, fontWeight = FontWeight.Bold)
        }
        ButtonRow(name = name, modifier = Modifier)

        // profile views count adds 1 when click

        // padding in kotlin padding right = padding(end = 16.dp) | padding left = padding(start = 16.dp)
        val profileViewsCount = remember { mutableIntStateOf(0)}
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "Profile Views: ${profileViewsCount.intValue}",
                modifier = Modifier.padding(end = 16.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Button(
                onClick = { profileViewsCount.intValue +=1 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple40, contentColor = Color.White
                )
            ) {
                Text(
                    "+1",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ButtonRow(name: String, modifier: Modifier = Modifier) {
    // remember keeps the value, mutableStateOf updates the UI
    val isFollowing = remember { mutableStateOf(false) }
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple40, contentColor = Color.White
            )) {
            Text("Message", fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = { isFollowing.value = !isFollowing.value },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
            border = BorderStroke(1.dp, Purple40)
        ) {
            Text( if (isFollowing.value) "Following" else "Follow",
                fontWeight = FontWeight.Bold)
        }
    }
}
