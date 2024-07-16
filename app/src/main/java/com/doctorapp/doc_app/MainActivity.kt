package com.doctorapp.doc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.doctorapp.doc_app.persentation.screen.MainScreen
import com.doctorapp.doc_app.ui.theme.Doc_appTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			Doc_appTheme {
//				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
				MainScreen()
//				}
			}
		}
	}
}

