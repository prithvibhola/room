package prithvi.io.room.ui.customer

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_customer.*
import prithvi.io.room.ui.base.BaseActivity
import prithvi.io.room.utility.Constants

class CustomerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        tvInfo.text = getString(R.string.database_version, Constants.DATABASE_VERSION)
    }
}