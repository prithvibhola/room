package prithvi.io.room.data.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [
    Customer::class
], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
}