package prithvi.io.room.ui.customer

import prithvi.io.room.data.repository.Repository
import prithvi.io.room.ui.base.BaseViewModel
import prithvi.io.room.utility.rx.Scheduler
import javax.inject.Inject

class CustomerViewModel @Inject constructor(
        private val repository: Repository,
        private val scheduler: Scheduler
) : BaseViewModel() {

}