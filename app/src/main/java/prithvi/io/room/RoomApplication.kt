package prithvi.io.room

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import prithvi.io.room.di.component.DaggerAppComponent
import prithvi.io.room.utility.logging.CrashReportingTree
import timber.log.Timber

class RoomApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else CrashReportingTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}
