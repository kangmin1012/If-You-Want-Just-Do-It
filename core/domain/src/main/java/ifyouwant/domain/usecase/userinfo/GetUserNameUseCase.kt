package ifyouwant.domain.usecase.userinfo

import ifyouwant.domain.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUserNameUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {
    operator fun invoke(): Flow<String> = userInfoRepository.getUserName()
}