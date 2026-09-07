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
import com.example.turnolab2.ui.theme.Purple80
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TurnoLab2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TurnoLab2Theme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.
        CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )    {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Avatar Logo",
            modifier = Modifier
                .fillMaxWidth(fraction = 0.3f)
                .clip(CircleShape)
                .padding(bottom = 16.dp)
                .border (
                    width = 2.dp,
                    color = Purple80,
                    shape = CircleShape,
                )
        )
       Text(
            "Kyle Tristan D. Turno",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        Text (
            "BSIT Student | Mobile Developer",
            color = Color.Gray,
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon (
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon",
                tint = Purple80,
                modifier = Modifier.size(18.dp)
            )
            Spacer (modifier = Modifier.width(5.dp))
            Text (
                "kyletristanturno2005@gmail.com",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon (
                imageVector = Icons.Default.Phone,
                contentDescription = "Phone Icon",
                tint = Purple80,
                modifier = Modifier.size(18.dp)
            )
            Spacer (modifier = Modifier.width(5.dp))
            Text (
                "+63 915 6006 472",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        ButtonRow (
            name = name,
            modifier = Modifier
        )
    }
}

@Composable
fun ButtonRow(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical
            = 8.dp),
        horizontalArrangement = Arrangement.spacedBy (
            8.dp, Alignment.CenterHorizontally
        )
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple80,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Message",
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Purple80)
        ) {
            Text(
                text = "Follow",
                fontWeight = FontWeight.Bold
            )
        }
    }
}



