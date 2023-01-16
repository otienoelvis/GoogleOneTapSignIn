package com.elvisotieno.googleonetap

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elvisotieno.googleonetap.ui.theme.GoogleOneTapSignInTheme
import com.elvisotieno.googleonetapcompose.GoogleOneTapSignIn
import com.elvisotieno.googleonetapcompose.rememberGoogleOneTapSignInState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleOneTapSignInTheme {
                val state = rememberGoogleOneTapSignInState()
                
                GoogleOneTapSignIn(
                    state = state,
                    clientId = "1031772653282-tng9pnugetvei90tckdn5hpah2kts7rs.apps.googleusercontent.com",
                    OnCredentialsReceived = {
                        Log.d("MainActivity", it.toString())
                    },
                    onDialogDismissed = {
                        Log.d("MainActivity", it)
                    }
                )

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { state.open() }, enabled = !state.opened) {
                        Text(text = "Sign in")
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleOneTapSignInTheme {
        Greeting("Android")
    }
}

