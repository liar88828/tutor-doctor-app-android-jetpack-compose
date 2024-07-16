package com.doctorapp.doc_app.persentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doctorapp.doc_app.R
import com.doctorapp.doc_app.ui.theme.poppinsFontFamily

@Composable
fun ScheduleTimeContent(
	modifier: Modifier = Modifier,
	contentColor: Color = Color.White,
//	title: String
) {
	Row(
		modifier = modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
		Content(icon = R.drawable.ic_date, contentColor = contentColor, title = "Sunday, 12 June")
		Content(
			icon = R.drawable.ic_clock,
			contentColor = contentColor,
			title = "11:00AM - 12:00AM"
		)
	}
}

@Composable
private fun Content(
	modifier: Modifier = Modifier, icon: Int, contentColor: Color, title: String
) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	) {
		Image(
			modifier = modifier.size(16.dp),
			painter = painterResource(id = icon),
			colorFilter = ColorFilter.tint(color = contentColor),
			contentDescription = "Icon Data"
		)
		Spacer(modifier = modifier.width(8.dp))

		Text(
			text = title,
			fontSize = 12.sp,
			fontWeight = FontWeight.W400,
			color = contentColor,
			fontFamily = poppinsFontFamily,
		)
	}
}

@Preview(showBackground = true)
@Composable
private fun ScheduleTimeContentPrev() {
	ScheduleTimeContent()
}