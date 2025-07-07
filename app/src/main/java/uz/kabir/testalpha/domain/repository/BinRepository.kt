package uz.kabir.testalpha.domain.repository

import uz.kabir.testalpha.data.model.BinResponse
import uz.kabir.testalpha.domain.model.BinData

interface BinRepository{
    suspend fun fetchAndCacheBin(bin: String): BinData?
    suspend fun getBinHistory(): List<BinData>
}