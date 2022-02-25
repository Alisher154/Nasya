package uz.texnopos.nasya.data.local.room.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "products")
@Parcelize
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo(name = "product_name") val productName: String,
    @ColumnInfo(name = "product_price") val productPrice: String
):Parcelable