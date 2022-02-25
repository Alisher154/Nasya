package uz.texnopos.nasya.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.*


@Dao
interface NasyaDao {

    //Clients
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun clientRegister(client: Client)

    @Query("select *from clients")
    fun getAllClients(): Flow<List<Client>>

    @Query("delete from clients where id=:clientId")
    fun deleteByClientId(clientId: Int)

    //Category
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCategory(category: Category)

    @Query("select * from categories")
    fun getAllCategories(): Flow<List<Category>>

    @Query("delete from categories where id=:categoryId")
    fun deleteCategoryById(categoryId: Int)

    //Product
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(product: Product)

    @Query("select *from products where category_id=:categoryId")
    fun getProductsByCategoryId(categoryId: Int): Flow<List<Product>>

    @Query("delete from products where id=:productId")
    fun deleteProductById(productId: Int)

    //Transactions
    @Insert
    suspend fun addTransaction(transaction: Transaction)

    @Query("select *from transactions where order_id=:orderId")
    fun getTransactionsByOrderId(orderId: Int): Flow<List<Transaction>>

    //Orders
    @Insert
    suspend fun addOrder(order: Order)

    @Query("select * from orders where client_id=:clientId")
    fun getOrdersByClientId(clientId: Int): Flow<List<Order>>


}