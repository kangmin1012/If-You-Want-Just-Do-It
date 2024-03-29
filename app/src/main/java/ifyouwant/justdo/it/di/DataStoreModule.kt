package ifyouwant.justdo.it.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ifyouwant.data.datastore.UserInfoDataStore
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideUserInfoDataStore(@ApplicationContext context: Context) = UserInfoDataStore(context)
}