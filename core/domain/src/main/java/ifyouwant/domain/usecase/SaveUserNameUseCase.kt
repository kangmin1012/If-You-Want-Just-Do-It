package ifyouwant.domain.usecase

import ifyouwant.domain.repository.UserInfoRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {
    suspend operator fun invoke(userName: String) {
        userInfoRepository.saveUserName(userName)
    }
}