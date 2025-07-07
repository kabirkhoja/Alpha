package uz.kabir.testalpha.domain.usecase

import uz.kabir.testalpha.domain.model.BinData
import uz.kabir.testalpha.domain.repository.BinRepository
import javax.inject.Inject

class GetBinDataUseCase @Inject constructor(private val binRepository: BinRepository) {
    suspend operator fun invoke(): List<BinData> {
        return binRepository.getBinHistory()
    }
}