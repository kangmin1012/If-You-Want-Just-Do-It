package ifyouwant.justdo.it.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ifyouwant.data.datasource.UserInfoDataSource
import ifyouwant.data.datastore.UserInfoDataStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideUserInfoDataSource(userInfoDataStore: UserInfoDataStore) = UserInfoDataSource(userInfoDataStore)
}