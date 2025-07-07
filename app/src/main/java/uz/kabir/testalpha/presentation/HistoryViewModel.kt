package uz.kabir.testalpha.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.kabir.testalpha.domain.model.BinData
import uz.kabir.testalpha.domain.usecase.GetBinDataUseCase
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val getBinDataUseCase: GetBinDataUseCase) :
    ViewModel() {
    private val _binList = MutableStateFlow<List<Pair<BinData, String>>>(emptyList())
    val binList: StateFlow<List<Pair<BinData, String>>> = _binList.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getBinHistory() {
        viewModelScope.launch {
            val result = getBinDataUseCase()
            val formattedData = result.map { bin ->
                val formatTime = Instant.ofEpochMilli(bin.timestamp).atZone(ZoneId.systemDefault())
                    .toLocalDateTime().format(
                    DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
                )
                bin to formatTime
            }
            _binList.value = formattedData
        }
    }
}