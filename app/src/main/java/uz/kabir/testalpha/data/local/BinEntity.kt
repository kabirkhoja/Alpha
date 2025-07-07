package uz.kabir.testalpha.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_history")
data class BinEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val bin: String,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val cardLength: Int?,
    val luhn: Boolean?,
    val countryName: String?,
    val countryEmoji: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?,
    val timestamp: Long
)