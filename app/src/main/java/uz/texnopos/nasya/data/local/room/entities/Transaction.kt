package uz.texnopos.nasya.data.local.room.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "transactions")
@Parcelize
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "order_id") val orderId: Int,
    @ColumnInfo(name = "paid_sum") val paidSum: Int,
    @ColumnInfo(name = "pay_date") val payDate: Long
):Parcelable