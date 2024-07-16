package com.doctorapp.doc_app.persentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doctorapp.doc_app.persentation.component.ScheduleDoctorCard
import com.doctorapp.doc_app.ui.theme.BluePrimary
import com.doctorapp.doc_app.ui.theme.poppinsFontFamily

@Composable
fun ScheduleScreen(modifier: Modifier = Modifier) {
	Column(modifier = modifier.fillMaxSize()) {
		LazyRow(
			modifier = modifier.padding(horizontal = 16.dp),
			horizontalArrangement = Arrangement.spacedBy(12.dp),
		) {
			// Category Schedule
			items(3) { CategorySchedule() }
		}

		LazyColumn(
			modifier = modifier.padding(horizontal = 16.dp, vertical = 24.dp),
			verticalArrangement = Arrangement.spacedBy(16.dp),
		) {
			items(5) {
				ScheduleDoctorCard()
			}
		}
	}
}

@Composable
fun CategorySchedule(modifier: Modifier = Modifier) {
	Surface(
		modifier = modifier
			.fillMaxWidth()
			.padding(top = 20.dp),
		color = Color(0xFF3CB1FF).copy(0.1f),
		shape = RoundedCornerShape(100.dp),
	) {
		Text(
			modifier = modifier.padding(16.dp),
			text = "Upcoming Schedule",
			fontFamily = poppinsFontFamily,
			color = BluePrimary,
			fontWeight = FontWeight.Medium,
			fontSize = 16.sp
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun ScheduleScreenPrev() {
	ScheduleScreen()
}