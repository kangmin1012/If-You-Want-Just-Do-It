package ifyouwant.domain.usecase.userinfo

import ifyouwant.domain.enumset.EnumGender
import ifyouwant.domain.repository.UserInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SaveUserGenderUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) {
    suspend operator fun invoke(gender: EnumGender) {
        runCatching {
            userInfoRepository.saveUserGender(gender.ordinal)
        }.onFailure {
            it.printStackTrace()
        }
    }
}