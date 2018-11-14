package prithvi.io.room.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import prithvi.io.room.di.ViewModelKey
import prithvi.io.room.ui.customer.CustomerViewModel
import prithvi.io.room.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CustomerViewModel::class)
    internal abstract fun searchViewModel(viewModel: CustomerViewModel): ViewModel
}