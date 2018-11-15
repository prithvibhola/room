package prithvi.io.room.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import dagger.Module
import dagger.Provides
import prithvi.io.room.data.persistence.Database
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(
            application: Application,
            callback: RoomDatabase.Callback,
            migrations: Set<@JvmSuppressWildcards Migration>
    ): Database {
        return Room.databaseBuilder(application, Database::class.java, "room.db")
                .addCallback(callback)
                .addMigrations(*migrations.toTypedArray())
                .build()
    }
}
