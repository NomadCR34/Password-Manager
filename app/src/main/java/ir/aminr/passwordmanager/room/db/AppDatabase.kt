package ir.aminr.passwordmanager.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.aminr.passwordmanager.model.Password
import ir.aminr.passwordmanager.room.dao.PasswordDao

@Database(
    entities = [
        Password::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun passwordDao(): PasswordDao
}