package ir.aminr.passwordmanager.room.dao

import androidx.room.*
import ir.aminr.passwordmanager.model.Password

@Dao
interface PasswordDao {

    @Query("SELECT p.* FROM passwords p WHERE p.id = :id")
    fun getPasswordById(id: Long):Password

    @Query("SELECT p.* FROM passwords p WHERE p.userID = :userID")
    fun getPasswordByUserID(userID: Long):List<Password>

    @Insert
    fun insertPassword(password: Password):Password

    @Delete
    fun deletePassword(password: Password)

    @Update
    fun updatePassword(password: Password)

}