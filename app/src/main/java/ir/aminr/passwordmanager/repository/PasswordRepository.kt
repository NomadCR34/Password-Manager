package ir.aminr.passwordmanager.repository

import ir.aminr.passwordmanager.model.Password
import ir.aminr.passwordmanager.room.dao.PasswordDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PasswordRepository
@Inject constructor(
    private val passwordDao: PasswordDao
) {

    suspend fun getPasswords(userID: Long):List<Password> = passwordDao.getPasswordByUserID(userID)

    suspend fun getPassword(passwordID: Long) = passwordDao.getPasswordById(passwordID)

    suspend fun deletePassword(password: Password) = passwordDao.deletePassword(password)

    suspend fun updatePassword(password: Password) = passwordDao.updatePassword(password)

    suspend fun insertPassword(password: Password) = passwordDao.insertPassword(password)

}