package uz.texnopos.nasya.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "order_id") val orderId: Int,
    @ColumnInfo(name = "paid_sum") val paidSum: Int,
    @ColumnInfo(name = "pay_date") val payDate: Long
)