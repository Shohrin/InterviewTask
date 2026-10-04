package com.example.interviewtask.presentation.components.vehiclelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.interviewtask.domain.model.VehicleDetailModel

@Composable
fun VehicleListItem(vehicleDetailModel: VehicleDetailModel,
                    onItemClick : (VehicleDetailModel) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()
        .clickable{
            onItemClick(vehicleDetailModel)
                }
        .padding(20.dp)
    , horizontalArrangement = Arrangement.SpaceBetween) {
        Text("${vehicleDetailModel.name}. ${vehicleDetailModel.model}. ${vehicleDetailModel.batteryPercent}. ${vehicleDetailModel.estimatedRange}", style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis)
    Text(text = if(vehicleDetailModel.status.equals("online")) "Online" else "Offline",
      color =  if(vehicleDetailModel.status.equals("online")) Color.Green else Color.Red, fontStyle = FontStyle.Italic,
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.align(Alignment.CenterVertically)
    )
    }
}