package com.uznewmax.clients.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Client(
    val id: Int? = null,
    val fullName: String,
    val documentNumber: String,
) : Parcelable