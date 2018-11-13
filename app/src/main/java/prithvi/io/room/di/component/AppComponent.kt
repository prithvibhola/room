package prithvi.io.room.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import prithvi.io.room.FlavourDI
import prithvi.io.room.RoomApplication
import prithvi.io.room.di.module.ActivityModule
import prithvi.io.room.di.module.AppModule
import prithvi.io.room.di.module.NetModule
import prithvi.io.room.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    AppModule::class,
    NetModule::class,
    ViewModelModule::class,
    FlavourDI::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: RoomApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}