package uz.kabir.testalpha.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBinData(binList: List<BinEntity>)

    @Query("select * from bin_history order by timestamp desc")
    suspend fun getBinHistory(): List<BinEntity>
}