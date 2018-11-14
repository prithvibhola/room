package prithvi.io.room.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import prithvi.io.room.di.ActivityScoped
import prithvi.io.room.ui.customer.CustomerActivity

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [])
    abstract fun customerActivity(): CustomerActivity

}