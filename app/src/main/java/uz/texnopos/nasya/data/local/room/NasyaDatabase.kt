package uz.texnopos.nasya.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.data.local.room.entities.Product

@Database(
    entities = [Client::class, Category::class, Product::class],
    version = 1,
    exportSchema = false
)
abstract class NasyaDatabase : RoomDatabase() {
    abstract fun dao(): NasyaDao
}