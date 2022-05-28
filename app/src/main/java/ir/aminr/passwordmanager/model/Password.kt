package ir.aminr.passwordmanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passwords")
data class Password(

    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var title:String,
    var description:String,
    @ColumnInfo(name = "create_date")
    var createDate:Long,
    @ColumnInfo(name = "update_date")
    var updateDate:Long,
    var userID:Long,
    var password:String,
    var url:String
)