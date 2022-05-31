package ir.aminr.passwordmanager.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.aminr.passwordmanager.util.PasswordGenerator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PasswordGenerator {

    @Singleton
    @Provides
    fun providePasswordGenerator():PasswordGenerator = PasswordGenerator()

}