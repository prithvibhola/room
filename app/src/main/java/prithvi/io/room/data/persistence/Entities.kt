package prithvi.io.room.data.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "customer")
data class Customer(
        @PrimaryKey @ColumnInfo(name = "id") @Json(name = "id") val id: Long = 0,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "gender") val gender: String,
        @ColumnInfo(name = "mobile") val mobile: String,
        @ColumnInfo(name = "landline") val landLine: String?,
        @ColumnInfo(name = "email") val email: String?,
        @ColumnInfo(name = "user_name") val userName: String,
        @ColumnInfo(name = "language") val languagePreference: String,
        @ColumnInfo(name = "wallet_amount") val walletAmount: Double?,
        @ColumnInfo(name = "profile_image_url") val profileImageUrl: String?,
        @ColumnInfo(name = "current_location") val currentLocation: String?,
        @ColumnInfo(name = "source") val source: String?
)