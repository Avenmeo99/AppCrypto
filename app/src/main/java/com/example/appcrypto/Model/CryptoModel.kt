package com.example.appcrypto.Model

import android.os.Parcel
import android.os.Parcelable

data class CryptoModel(
    val Symbol: String = "",
    val ShortSymbol: String = "",
    val Price: Double,
    val ChangePercent: Double,
    val AmountNumber: Double,
    val AmountRupiah: Double,
    val JualPrice1: Double,
    val JualPrice2: Double,
    val JualPrice3: Double,
    val JualPrice4: Double,
    val JualPrice5: Double,
    val JualAmount1: Double,
    val JualAmount2: Double,
    val JualAmount3: Double,
    val JualAmount4: Double,
    val JualAmount5: Double,
    val BeliPrice1: Double,
    val BeliPrice2: Double,
    val BeliPrice3: Double,
    val BeliPrice4: Double,
    val BeliPrice5: Double,
    val BeliAmount1: Double,
    val BeliAmount2: Double,
    val BeliAmount3: Double,
    val BeliAmount4: Double,
    val BeliAmount5: Double,
    val Open: Double,
    val Close: Double,
    val High: Double,
    val Low: Double,
    val DailyChange: Double,
    val DailyVol: Double,
    val SymboLogo: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Symbol)
        parcel.writeString(ShortSymbol)
        parcel.writeDouble(Price)
        parcel.writeDouble(ChangePercent)
        parcel.writeDouble(AmountNumber)
        parcel.writeDouble(AmountRupiah)
        parcel.writeDouble(JualPrice1)
        parcel.writeDouble(JualPrice2)
        parcel.writeDouble(JualPrice3)
        parcel.writeDouble(JualPrice4)
        parcel.writeDouble(JualPrice5)
        parcel.writeDouble(JualAmount1)
        parcel.writeDouble(JualAmount2)
        parcel.writeDouble(JualAmount3)
        parcel.writeDouble(JualAmount4)
        parcel.writeDouble(JualAmount5)
        parcel.writeDouble(BeliPrice1)
        parcel.writeDouble(BeliPrice2)
        parcel.writeDouble(BeliPrice3)
        parcel.writeDouble(BeliPrice4)
        parcel.writeDouble(BeliPrice5)
        parcel.writeDouble(BeliAmount1)
        parcel.writeDouble(BeliAmount2)
        parcel.writeDouble(BeliAmount3)
        parcel.writeDouble(BeliAmount4)
        parcel.writeDouble(BeliAmount5)
        parcel.writeDouble(Open)
        parcel.writeDouble(Close)
        parcel.writeDouble(High)
        parcel.writeDouble(Low)
        parcel.writeDouble(DailyChange)
        parcel.writeDouble(DailyVol)
        parcel.writeString(SymboLogo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<CryptoModel> {
            override fun createFromParcel(parcel: Parcel): CryptoModel {
                return CryptoModel(parcel)
            }

            override fun newArray(size: Int): Array<CryptoModel?> {
                return arrayOfNulls(size)
            }
        }
    }
}