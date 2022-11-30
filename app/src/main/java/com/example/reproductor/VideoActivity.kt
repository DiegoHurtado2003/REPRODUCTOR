package com.example.reproductor

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class VideoActivity : AppCompatActivity(){
    private lateinit var videoView: VideoView
    private lateinit var textView: TextView
    private var namelist = arrayOf("DUKI || BZRP Music Sessions #50","Eladio Carrión - Si La Calle Llama (Visualizer) | SEN2 KBRN VOL. 2","Eladio Carrión, Bad Bunny - Kemba Walker (Audio Oficial)")
    private var playlist = arrayOf(R.raw.duki_video, R.raw.si_la_calle_llama_video, R.raw.kemba_walker_video)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById(R.id.vistaVideos)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)


        val onlineUri = Uri.parse("https://assets.mixkit.co/videos/preview/mixkit-people-pouring-a-warm-drink-around-a-campfire-513-large.mp4")
        val offlineUri = Uri.parse("android.resource://$packageName/${playlist[MainActivity.contador]}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(offlineUri)

        videoView.requestFocus()
        videoView.start()


        textView = findViewById(R.id.songNameVideo)


        textView.text = namelist[MainActivity.contador]
    }
}