package uz.kabir.testalpha.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import uz.kabir.testalpha.data.model.BinResponse

interface ApiService {
    @GET("{bin}")
    suspend fun getCardInfo(@Path("bin") bin: String): Response<BinResponse>
}