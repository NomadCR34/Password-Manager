package ir.aminr.passwordmanager.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aminr.passwordmanager.repository.PasswordRepository
import ir.aminr.passwordmanager.room.dao.PasswordDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PasswordRepository {

    @Provides
    @Singleton
    fun providePasswordRepository(
        passwordDao: PasswordDao
    ) = PasswordRepository(passwordDao)

}