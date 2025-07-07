package uz.kabir.testalpha.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.kabir.testalpha.domain.usecase.FetchDataUseCase
import uz.kabir.testalpha.domain.model.BinData
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchDataUseCase: FetchDataUseCase) : ViewModel() {

    private val _getBinResponse = MutableStateFlow<BinData?>(null)
    val getBinResponse: StateFlow<BinData?> = _getBinResponse.asStateFlow()

    fun getCardInfo(bin: String) {
        viewModelScope.launch {
            val response = fetchDataUseCase(bin)
            _getBinResponse.value = response
        }

    }

}