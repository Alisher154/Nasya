package uz.texnopos.nasya.data.local.room.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "clients")
@Parcelize
data class Client(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "full_name") val fullName: String,
    @ColumnInfo(name = "document_number") val documentNumber: String,
):Parcelable