package prithvi.io.room.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import prithvi.io.room.ui.githubsearch.SearchActivity
import prithvi.io.room.di.ActivityScoped

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [])
    abstract fun searchActivity(): SearchActivity

}