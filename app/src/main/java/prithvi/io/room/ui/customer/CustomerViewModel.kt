package prithvi.io.room.ui.customer

import android.arch.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.subscribeBy
import prithvi.io.room.data.models.Response
import prithvi.io.room.data.persistence.Customer
import prithvi.io.room.data.repository.Repository
import prithvi.io.room.ui.base.BaseViewModel
import prithvi.io.room.utility.extentions.addTo
import prithvi.io.room.utility.extentions.fromWorkerToMain
import prithvi.io.room.utility.rx.Scheduler
import timber.log.Timber
import javax.inject.Inject

class CustomerViewModel @Inject constructor(
        private val repository: Repository,
        private val scheduler: Scheduler
) : BaseViewModel() {

    val customer: MutableLiveData<Response<List<Customer>>> = MutableLiveData()
    val insertCustomer: MutableLiveData<Response<Long>> = MutableLiveData()

    fun getCustomer() {
        repository.customer.getCustomer()
                .fromWorkerToMain(scheduler)
                .subscribeBy(
                        onNext = {
                            customer.value = Response.success(it)
                        },
                        onError = {
                            customer.value = Response.error(it)
                            Timber.e(it, "Could not get customer from database!!")
                        }
                )
                .addTo(getCompositeDisposable())
    }

    fun insertCustomer(customer: Customer) {
        repository.customer.getCustomer()
                .filter { it.isEmpty() }
                .flatMap { repository.customer.insertCustomer(customer) }
                .fromWorkerToMain(scheduler)
                .subscribeBy(
                        onNext = {
                            insertCustomer.value = Response.success(it)
                        },
                        onError = {
                            insertCustomer.value = Response.error(it)
                            Timber.e(it, "Error in inserting customer into database!!")
                        }
                )
                .addTo(getCompositeDisposable())
    }
}