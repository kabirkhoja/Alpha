package uz.kabir.testalpha.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.kabir.testalpha.data.local.BinDao
import uz.kabir.testalpha.data.local.BinDatabase

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): BinDatabase {
        return Room.databaseBuilder(context, BinDatabase::class.java, "bin_database").build()
    }

    @Provides
    fun provideBinDao(binDatabase: BinDatabase): BinDao{
        return binDatabase.binDao()
    }
}