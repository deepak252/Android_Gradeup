package com.example.ecommerceapp.model

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val id : Int,
    val price : Double,
    val title : String?,
    val category: String?,
    val description : String?,
    val imgUrl : String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeDouble(price)
        parcel.writeString(title)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeString(imgUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
