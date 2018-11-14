package prithvi.io.room.data.persistence

import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(customer: Customer): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(customers: List<Customer>): List<Long>

    @Query("SELECT * FROM customer WHERE id = :id")
    fun selectById(id: Long): Flowable<Customer>

    @Query("SELECT * FROM customer")
    fun selectAll(): Flowable<List<Customer>>

    @Update
    fun update(customer: Customer): Int

    @Query("DELETE FROM customer WHERE id = :id")
    fun deleteById(id: Long): Int

    @Query("DELETE FROM customer")
    fun deleteAll(): Int
}