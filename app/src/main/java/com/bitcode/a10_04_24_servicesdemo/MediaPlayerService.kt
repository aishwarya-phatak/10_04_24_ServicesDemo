package com.bitcode.a10_04_24_servicesdemo

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast

class MediaPlayerService : Service() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var uri : Uri

    override fun onCreate() {
        super.onCreate()
        makeToast("onCreate called")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        makeToast("onStartCommand called -- $startId")

        if (intent != null){
            var path = intent.getStringExtra("file_path")
            uri = Uri.parse(path)
        }

        mediaPlayer = MediaPlayer.create(this,uri)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        return START_STICKY
    }
    override fun onBind(p0: Intent?): IBinder? {
        makeToast("onBind Called")
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        makeToast("on Destroy Called")
        mediaPlayer.stop()
    }

    private fun makeToast(text : String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}