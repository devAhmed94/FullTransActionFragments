package com.example.fullTransactionFragments.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 27/05/2021
 */
data class Name(val name: String, val id: Int) : Parcelable {

  constructor(parcel: Parcel) : this(
    parcel.readString().toString(),
    parcel.readInt()
  ) {
  }

  override fun describeContents() = id

  override fun writeToParcel(dest: Parcel?, flags: Int) {
  }

  companion object CREATOR : Parcelable.Creator<Name> {

    override fun createFromParcel(parcel: Parcel): Name {
      return Name(parcel)
    }

    override fun newArray(size: Int): Array<Name?> {
      return arrayOfNulls(size)
    }
  }
}
