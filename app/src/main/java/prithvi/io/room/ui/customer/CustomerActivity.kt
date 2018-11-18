package prithvi.io.room.ui.customer

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_customer.*
import prithvi.io.room.data.models.Response
import prithvi.io.room.data.persistence.Customer
import prithvi.io.room.ui.base.BaseActivity
import prithvi.io.room.utility.Constants
import prithvi.io.room.utility.extentions.getViewModel
import prithvi.io.room.utility.extentions.observe
import prithvi.io.room.utility.extentions.toast
import javax.inject.Inject
import prithvi.io.room.R

class CustomerActivity : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CustomerViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        viewModel = getViewModel(CustomerViewModel::class.java, viewModelFactory)

        viewModel.insertCustomer(
                Customer(
                        name = "Github",
                        gender = "Male",
                        mobile = "1234567890",
                        landLine = "12345-12345",
                        email = "github@gmail.com",
                        userName = "git",
                        languagePreference = "English",
                        walletAmount = 0.0,
                        profileImageUrl = "https://github.com/logos",
                        currentLocation = "Internet",
                        source = "ANDROID"
                )
        )
        viewModel.getCustomer()

        tvInfo.text = getString(R.string.database_version, Constants.DATABASE_VERSION)
        observe(viewModel.customer) {
            it ?: return@observe
            when (it.status) {
                Response.Status.LOADING -> TODO()
                Response.Status.SUCCESS -> {
                    if (it.data == null || it.data.isEmpty()) return@observe
                    val customer = it.data[0]
                    tvCustomerData.text =
                            "id : ${customer.id}\n" +
                            "name : ${customer.name}\n" +
                            "mobile : ${customer.mobile}\n" +
                            "landline: ${customer.landLine}\n" +
                            "email: ${customer.email}\n" +
                            "userName: ${customer.userName}\n" +
                            "language: ${customer.languagePreference}\n" +
                            "walletAmount: ${customer.walletAmount}\n" +
                            "profileImageUrl: ${customer.profileImageUrl}\n" +
                            "location: ${customer.currentLocation}\n" +
                            "source: ${customer.source}\n"
                }
                Response.Status.ERROR -> toast("Error in getting customer from database")
            }
        }
    }
}