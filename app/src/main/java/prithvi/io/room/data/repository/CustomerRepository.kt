package prithvi.io.room.data.repository

import io.reactivex.Flowable
import prithvi.io.room.data.persistence.Customer
import prithvi.io.room.data.persistence.Database
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomerRepository @Inject constructor(
        private val database: Database
) {

    fun getCustomer() = database.customerDao().selectAll()

    fun insertCustomer(customer: Customer): Flowable<Long> =
            Flowable.just(customer).map { database.customerDao().insert(customer) }
}