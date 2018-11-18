package prithvi.io.room.di.module

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.content.ContentValues
import android.database.sqlite.SQLiteException
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import prithvi.io.room.data.persistence.Database
import timber.log.Timber
import java.lang.Exception
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(
            application: Application,
            migrations: Set<@JvmSuppressWildcards Migration>
    ): Database {
        return Room.databaseBuilder(application, Database::class.java, "room.db")
                .addMigrations(*migrations.toTypedArray())
                .build()
    }

    @Provides
    @IntoSet
    @Singleton
    fun provide1To2Migration(): Migration {
        return object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                try {
                    val cursor = database.query("SELECT * FROM customer")
                    cursor.use {
                        if (cursor.moveToFirst()) {
                            val contentValues = ContentValues()
                            contentValues.put("id", cursor.getLong(cursor.getColumnIndex("id")))
                            contentValues.put("name", cursor.getString(cursor.getColumnIndex("name")))
                            contentValues.put("gender", cursor.getString(cursor.getColumnIndex("gender")))
                            contentValues.put("mobile", cursor.getString(cursor.getColumnIndex("mobile")))
                            contentValues.put("landline", cursor.getString(cursor.getColumnIndex("landline")))
                            contentValues.put("email", cursor.getString(cursor.getColumnIndex("email")))
                            contentValues.put("user_name", cursor.getString(cursor.getColumnIndex("user_name")))
                            contentValues.put("language", cursor.getString(cursor.getColumnIndex("language")))
                            contentValues.put("wallet_amount", cursor.getDouble(cursor.getColumnIndex("wallet_amount")))
                            contentValues.put("profile_image_url", cursor.getString(cursor.getColumnIndex("profile_image_url")))
                            contentValues.put("current_location", cursor.getString(cursor.getColumnIndex("current_location")))
                            contentValues.put("source", "Android")

                            database.execSQL("DROP TABLE IF EXISTS `customer`")
                            database.execSQL("""CREATE TABLE IF NOT EXISTS `customer` (
                                `id` INTEGER NOT NULL,
                                `name` TEXT NOT NULL,
                                `gender` TEXT NOT NULL,
                                `mobile` TEXT NOT NULL,
                                `landline` TEXT,
                                `email` TEXT,
                                `user_name` TEXT NOT NULL,
                                `language` TEXT NOT NULL,
                                `wallet_amount` REAL,
                                `profile_image_url` TEXT,
                                `current_location` TEXT,
                                `source` TEXT,
                                PRIMARY KEY(`id`))""".trimIndent())

                            database.insert("customer", 0, contentValues)
                        } else {
                            database.execSQL("DROP TABLE IF EXISTS `customer`")
                            database.execSQL("""CREATE TABLE IF NOT EXISTS `customer` (
                                `id` INTEGER NOT NULL,
                                `name` TEXT NOT NULL,
                                `gender` TEXT NOT NULL,
                                `mobile` TEXT NOT NULL,
                                `landline` TEXT,
                                `email` TEXT,
                                `user_name` TEXT NOT NULL,
                                `language` TEXT NOT NULL,
                                `wallet_amount` REAL,
                                `profile_image_url` TEXT,
                                `current_location` TEXT,
                                `source` TEXT,
                                PRIMARY KEY(`id`))""".trimIndent())
                        }
                    }
                } catch (e: SQLiteException) {
                    Timber.e(e, "SQLiteException in migrate from database version 1 to version 2")
                } catch (e: Exception) {
                    Timber.e(e, "Failed to migrate database version 1 to version 2")
                }
            }
        }
    }
}
