package com.dallmeie.ibrdtn

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.dallmeie.ibrdtn.App.CHANNEL_ID

class DaemonService : Service() {

    val TAG = "DaemonService"

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("onStartCommand")

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Daemon Service")
            .setContentText("Blafoo")
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        return START_STICKY
    }

    override fun onDestroy() {
        ShowLog("onDestroy")
        super.onDestroy()
    }

    fun ShowLog(message: String){
        Log.d(TAG, message)
    }
}
