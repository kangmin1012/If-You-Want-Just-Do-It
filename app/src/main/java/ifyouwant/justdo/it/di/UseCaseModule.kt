package ifyouwant.justdo.it.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ifyouwant.domain.repository.UserInfoRepository
import ifyouwant.domain.usecase.GetUserNameUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserNameUseCase(userInfoRepository: UserInfoRepository) = GetUserNameUseCase(userInfoRepository)
}