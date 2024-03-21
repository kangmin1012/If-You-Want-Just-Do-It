package ifyouwant.domain.usecase

import ifyouwant.domain.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {
    operator fun invoke(): Flow<String> = userInfoRepository.getUserName()
}