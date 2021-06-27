package com.example.custom_broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SendBroadcastActivity : AppCompatActivity() {

    var receiver : BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_broadcast)
        configureReceiver()

    }

    private  fun configureReceiver(){
        val filter = IntentFilter()
        filter.addAction("com.example.custom_broadcastreceiver")
        receiver = MyReceiver()
        registerReceiver(receiver, filter)

    }
    fun broadcastIntent(view: View) {
        val intent = Intent()
        intent.action = "com.example.custom_broadcastreceiver"
        intent.flags= Intent.FLAG_INCLUDE_STOPPED_PACKAGES
        sendBroadcast(intent)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}