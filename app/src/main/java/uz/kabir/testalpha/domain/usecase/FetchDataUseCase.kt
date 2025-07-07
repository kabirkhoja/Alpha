package uz.kabir.testalpha.domain.usecase

import uz.kabir.testalpha.domain.model.BinData
import uz.kabir.testalpha.domain.repository.BinRepository
import javax.inject.Inject

class FetchDataUseCase @Inject constructor(private val binRepository: BinRepository) {
    suspend operator fun invoke(bin: String): BinData? {
        return binRepository.fetchAndCacheBin(bin)
    }
}