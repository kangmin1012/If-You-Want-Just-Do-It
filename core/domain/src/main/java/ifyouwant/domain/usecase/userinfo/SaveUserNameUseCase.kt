package ifyouwant.domain.usecase.userinfo

import ifyouwant.domain.repository.UserInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SaveUserNameUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {
    suspend operator fun invoke(userName: String) {
        userInfoRepository.saveUserName(userName)
    }
}