package uz.texnopos.nasya.data.local.sharedpref

import android.content.Context
import javax.inject.Inject

class SharedPref @Inject constructor(private val context: Context) {

    private val pref = context.getSharedPreferences("NewMobileBanking", Context.MODE_PRIVATE)

}