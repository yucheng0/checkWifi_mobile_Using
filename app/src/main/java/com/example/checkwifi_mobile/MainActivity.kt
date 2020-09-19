package com.example.checkwifi_mobile

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
/*   https://www.youtube.com/watch?v=trZL3Nilpbg
*/


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
btnCheck.setOnClickListener {
    checkConnType()
}
    }

fun checkConnType(){
    val connManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val wifiConn = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
    val mobileDataConn = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
    if (wifiConn!!.isConnectedOrConnecting) txtState.text = "Wifi Connection"
    else if (mobileDataConn!!.isConnectedOrConnecting) txtState.text = "Mobile Data Connection"
    else txtState.text = "No NetWork Connection"
}

}