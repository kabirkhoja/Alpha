package uz.kabir.testalpha.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.kabir.testalpha.data.repository.BinRepositoryImp
import uz.kabir.testalpha.domain.repository.BinRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindBinRepository(binRepositoryImpl: BinRepositoryImp): BinRepository
}