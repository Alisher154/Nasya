package uz.texnopos.nasya.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "product_id") val productId:Int,
    @ColumnInfo(name = "start_date") val startDate:Int,
    @ColumnInfo(name = "month") val month:Int
)
