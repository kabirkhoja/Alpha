package uz.kabir.testalpha.data.repository

import uz.kabir.testalpha.data.local.BinDao
import uz.kabir.testalpha.data.mapper.toDomain
import uz.kabir.testalpha.data.mapper.toEntity
import uz.kabir.testalpha.data.remote.ApiService
import uz.kabir.testalpha.domain.model.BinData
import uz.kabir.testalpha.domain.repository.BinRepository
import javax.inject.Inject

class BinRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val binDao: BinDao
) : BinRepository {
    override suspend fun fetchAndCacheBin(bin: String): BinData? {
        return try {
            val response = apiService.getCardInfo(bin)
            if (response.isSuccessful) {
                response.body()?.toDomain(bin)?.also { binData ->
                    binDao.insertBinData(listOf(binData.toEntity()))
                }
            } else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getBinHistory(): List<BinData> {
        return binDao.getBinHistory().map { it.toDomain() }

    }

}