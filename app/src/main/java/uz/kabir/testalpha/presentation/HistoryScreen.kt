package uz.kabir.testalpha.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import uz.kabir.testalpha.domain.model.BinData

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailScreen(
    navController: NavHostController,
    historyViewModel: HistoryViewModel = hiltViewModel()
) {

    val list = historyViewModel.binList.collectAsState().value
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<BinData?>(null) }

    LaunchedEffect(Unit) {
        historyViewModel.getBinHistory()
    }


    LazyColumn(modifier = Modifier.padding(top = 32.dp)) {
        items(list) { (item, time) ->
            Item(
                binItem = item,
                binTime = time,
                onClick = {
                    selectedItem = item
                    showDialog = true
                })
        }
    }

    if (showDialog && selectedItem != null) {
        CustomAlertDialog(
            onDismiss = { showDialog = false },
            title = "BIN: ${selectedItem!!.bin}",
            message = "ALL INFORMATION: $selectedItem"
        )
    }


}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Item(binItem: BinData, onClick: () -> Unit, binTime: String) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.LightGray)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            binItem.bin, modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            binTime,
            modifier = Modifier.padding(end = 16.dp),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun CustomAlertDialog(
    onDismiss: () -> Unit,
    title: String,
    message: String
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            TextButton(onClick = {
                onDismiss()
            }) {
                Text("OK")
            }
        }
    )
}