package com.doctorapp.doc_app.persentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doctorapp.doc_app.R
import com.doctorapp.doc_app.ui.theme.PurpleGrey
import com.doctorapp.doc_app.ui.theme.TextColorTitle
import com.doctorapp.doc_app.ui.theme.poppinsFontFamily

@Composable
fun ScheduleDoctorCard(modifier: Modifier = Modifier) {
	Surface(
		modifier = modifier.fillMaxWidth(),
		color = Color.White,
		shape = RoundedCornerShape(12.dp),
		shadowElevation = 0.2.dp,
		tonalElevation = 0.5.dp
	) {
		Column(
			modifier = modifier.padding(vertical = 16.dp, horizontal = 20.dp)
		) {
			Row {
				Image(
					modifier = modifier.size(40.dp),
					painter = painterResource(id = R.drawable.img_doctor_1),
					contentDescription = "Doctor Image 1"
				)
				Column(
					modifier = modifier
						.padding(start = 12.dp)
						.weight(1f)
				) {
					Text(
						text = "Dr. Ibnu Sina",
						fontFamily = poppinsFontFamily,
						fontWeight = FontWeight.Bold,
						color = TextColorTitle
					)
					Text(
						text = "General Doctor",
						fontFamily = poppinsFontFamily,
						fontWeight = FontWeight.Light,
						color = PurpleGrey
					)
				}

				Row(
//					modifier=modifier.align(),
					horizontalArrangement = Arrangement.spacedBy(2.dp),
					verticalAlignment = Alignment.CenterVertically
				) {
					Image(
						modifier = modifier.size(14.dp),
						imageVector = Icons.Default.LocationOn,
						contentDescription = "Location Icon",
						colorFilter = ColorFilter.tint(PurpleGrey)
					)
					Text(
						text = "1.2km",
						fontFamily = poppinsFontFamily,
						fontWeight = FontWeight.W400,
						color = PurpleGrey
					)
				}
			}


			HorizontalDivider(
				modifier = modifier
					.fillMaxWidth()
					.padding(vertical = 10.dp)
					.height(1.dp)
					.alpha(0.1f),
				color = Color.Gray
			)
			ScheduleTimeContent(contentColor = PurpleGrey)

			Button(
				modifier = modifier
					.fillMaxWidth()
					.padding(top = 20.dp),
				colors = ButtonDefaults.buttonColors(Color(0xFF2B93E2).copy(0.1f)),
				onClick = {}) {
				Text(
					text = "Detail",
					fontFamily = poppinsFontFamily,
					fontWeight = FontWeight.Medium,
					color = Color(0xFF2B93E2)
				)
			}
		}
	}


}

@Preview//(showBackground = true)
@Composable
private fun ScheduleDoctorCardPrev() {
	ScheduleDoctorCard()
}