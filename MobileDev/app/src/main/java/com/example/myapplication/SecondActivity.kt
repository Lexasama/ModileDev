package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class SecondActivity : AppCompatActivity() {

    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv = findViewById(R.id.second_title)

//        val button1 = findViewById<Button>(R.id.button6)
//        button1.setOnClickListener{
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.containerFragment, Fragment1.newInstance())
//                .commit()
//            tv.text = "Fragment1"
//        }
//
//        val button2 = findViewById<Button>(R.id.button7)
//        button2.setOnClickListener{
//            val dialog = AlertDialog.Builder(this)
//            dialog.setMessage("voulez vous quitter la page ?")
//                dialog.setPositiveButton("ok", {dialog, id ->
//                    toPage3()
//                })
//            dialog.create().show();
//
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.containerFragment, Fragment2.newInstance())
//                .commit()
//            tv.text = "Fragment2"
//            sendNotification()
//
//
//        }
//
//        val button3 = findViewById<Button>(R.id.button8)
//        button3.setOnClickListener{
//            toPage3()
//        }
    }

    fun toPage3(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerFragment, Fragment3.newInstance())
            .commit()
        tv.text = "Fragment3"
    }

    fun sendNotification (){

        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "YOUR_CHANNEL_ID",
                "YOUR_CHANNEL_NAME",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "YOUR_NOTIFICATION_CHANNEL_DESCRIPTION"
            mNotificationManager.createNotificationChannel(channel)
        }


      val builder =  NotificationCompat.Builder(this, "YOUR_CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Much longer text that cannot fit one line...")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(1, builder.build())
        }
    }
}