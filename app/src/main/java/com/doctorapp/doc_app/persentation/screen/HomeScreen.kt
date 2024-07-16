package com.doctorapp.doc_app.persentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.sp
import com.doctorapp.doc_app.R
import com.doctorapp.doc_app.persentation.component.MenuHome
import com.doctorapp.doc_app.persentation.component.NearDoctorCard
import com.doctorapp.doc_app.persentation.component.ScheduleTimeContent
import com.doctorapp.doc_app.ui.theme.BluePrimary
import com.doctorapp.doc_app.ui.theme.GraySecond
import com.doctorapp.doc_app.ui.theme.PurpleGrey
import com.doctorapp.doc_app.ui.theme.WhiteBackground
import com.doctorapp.doc_app.ui.theme.poppinsFontFamily

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
	Surface(
		modifier = modifier.padding(
			top = 42.dp, start = 16.dp, end = 16.dp
		)
	) {
		Column {
			HeaderContent()
			Spacer(modifier = Modifier.height(24.dp))

			ScheduleContent()

			TextField(
				modifier = modifier
					.fillMaxWidth()
					.padding(top = 20.dp),
				leadingIcon = {
					Image(
						painter = painterResource(id = R.drawable.ic_search),
						contentDescription = "Search Icon"
					)
				},
				placeholder = {
					Text(
						text = "Search doctor or health issue",
						fontWeight = FontWeight.W400,
						color = PurpleGrey,
						fontFamily = poppinsFontFamily
					)
				},
				colors = TextFieldDefaults.colors(
					unfocusedContainerColor = WhiteBackground,
					focusedIndicatorColor = Color.Transparent,
					unfocusedIndicatorColor = Color.Transparent,
					disabledIndicatorColor = Color.Transparent
				),
				shape = RoundedCornerShape(12.dp),
				value = "",
				onValueChange = {},
			)

			Row(
				modifier = modifier
					.fillMaxWidth()
					.padding(top = 24.dp),
				horizontalArrangement = Arrangement.SpaceBetween,
			) {
				MenuHome(icon = R.drawable.ic_covid, title = "Home")
				MenuHome(icon = R.drawable.ic_doctor, title = "Doctor")
				MenuHome(icon = R.drawable.ic_medicine, title = "Medicine")
				MenuHome(icon = R.drawable.ic_hospital, title = "Hospital")
			}
			//      Near Content
			Text(
				modifier = modifier.padding(top = 32.dp),
				text = "Near Doctor",
				fontFamily = poppinsFontFamily,
				fontWeight = FontWeight.Bold,
				color = PurpleGrey,
				fontSize = 16.sp,
			)
//List Doctor
			LazyColumn(
				modifier = modifier.padding(top = 16.dp),
				verticalArrangement = Arrangement.spacedBy(8.dp),
				contentPadding = PaddingValues(bottom = 16.dp)
			) {
				items(10) {
					NearDoctorCard()
				}
			}
		}
	}

}

@Composable
private fun ScheduleContent(modifier: Modifier = Modifier) {
	Surface(
		modifier = modifier.fillMaxWidth(),
		shape = RoundedCornerShape(12.dp),
		color = BluePrimary,
		tonalElevation = 1.dp,
		shadowElevation = 2.dp
	) {
		Column(modifier = modifier.padding(vertical = 16.dp, horizontal = 24.dp)) {
			Row(
				modifier = modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				Image(
					modifier = modifier.size(48.dp),
					painter = painterResource(id = R.drawable.img_doctor_1),
					contentDescription = "Image Doctor"
				)
				Column(
					modifier
						.padding(start = 12.dp)
						.weight(1f),
				) {
					Text(
						text = "Dr. Ibnu Sina",
						fontFamily = poppinsFontFamily,
						fontWeight = FontWeight.Bold,
						color = Color.White
					)
					Text(
						text = "General Doctor",
						fontFamily = poppinsFontFamily,
						fontWeight = FontWeight.Light,
						color = GraySecond
					)
				}
				Image(
					modifier = modifier.size(24.dp),
					imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
					contentDescription = "Arrow Next",
					colorFilter = ColorFilter.tint(color = Color.White)
				)
			}

			HorizontalDivider(
				modifier = modifier
					.fillMaxWidth()
					.padding(vertical = 16.dp)
					.height(1.dp)
					.alpha(0.2f),
				color = Color.White
			)
//			Schedule Time Content
			ScheduleTimeContent()
		}
	}
}

@Composable
fun HeaderContent(modifier: Modifier = Modifier) {
	Row(
		modifier = modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Column {
			Text(
				text = "Hello",
				fontFamily = poppinsFontFamily,
				fontWeight = FontWeight.W400,
				color = PurpleGrey
			)

			Spacer(modifier = Modifier.height(4.dp))

			Text(
				text = "Hi User Brian",
				fontFamily = poppinsFontFamily,
				fontWeight = FontWeight.Bold,
				fontSize = 20.sp
			)
		}
		Image(
			modifier = modifier.size(54.dp),
			painter = painterResource(id = R.drawable.img_header_content),
			contentDescription = "Image Header Content"
		)
	}
}

@Preview(
	showBackground = true, showSystemUi = true
)
@Composable
private fun HomeScreenPrev() {
	HomeScreen()

}