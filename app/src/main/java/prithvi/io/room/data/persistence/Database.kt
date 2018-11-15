package prithvi.io.room.data.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import prithvi.io.room.utility.Constants

@Database(entities = [
    Customer::class
], version = Constants.DATABASE_VERSION)
abstract class Database : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
}