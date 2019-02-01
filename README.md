# Room
> This is a simple example to demonstrate the Room migration in case in which we want to 
> 1. Change the datatype of a column in table
> 2. Make fields either nullable or non-nullable
> 3. Rename the column name
> 4. Add or remove columns from the table

# Migration

First build the project with the commit : `05204801051367f1796d74e98dbc7982ad9af7e5`
> In this commit we have customer model as:

```@Entity(tableName = "customer")
data class Customer(
        @PrimaryKey @ColumnInfo(name = "id") @Json(name = "id") val id: Long = 0,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "gender") val gender: String,
        @ColumnInfo(name = "mobile") val mobile: String,
        @ColumnInfo(name = "landline") val landLine: String,
        @ColumnInfo(name = "email") val email: String,
        @ColumnInfo(name = "user_name") val userName: String,
        @ColumnInfo(name = "language") val languagePreference: String,
        @ColumnInfo(name = "wallet_amount") val walletAmount: Long,
        @ColumnInfo(name = "profile_image_url") val profileImageUrl: String,
        @ColumnInfo(name = "current_location") val currentLocation: String
)
```

Then over this commit build this commit : `afcc717f5cfa311117e06aeecef1cb52ecad0510`
> Which has customer model as:

```@Entity(tableName = "customer")
data class Customer(
        @PrimaryKey @ColumnInfo(name = "id") val id: Long = 0,
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
```

# Project uses:
- [Koltin]()
- [RxJava2](https://github.com/ReactiveX/RxJava), [RxAndroid](https://github.com/ReactiveX/RxAndroid) and [RxKotlin](https://github.com/ReactiveX/RxKotlin)
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/)
- [Retrofit](http://square.github.io/retrofit/) / [OkHttp](http://square.github.io/okhttp/)
- [Moshi](https://github.com/square/moshi)
- [Dagger 2](https://google.github.io/dagger/)
- [Google Play Services](https://developers.google.com/android/guides/overview)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide 3](https://github.com/bumptech/glide)
- [Stetho](http://facebook.github.io/stetho/)
- [Chuck](https://github.com/jgilfelt/chuck)
- [Progress Activity](https://github.com/vlonjatg/progress-activity)
