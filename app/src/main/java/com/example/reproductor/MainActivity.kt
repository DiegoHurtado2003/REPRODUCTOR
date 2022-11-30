package com.example.reproductor

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var btnPlay: ImageButton? = null
    private var btnNext: ImageButton? = null
    private var btnPrevius: ImageButton? = null
    private var imageview: ImageView? = null
    private var textView: TextView? = null
    private var btnStream: Button? = null
    private var btnVideo: Button? = null

    companion object {
        var contador: Int = 0
    }


    private var mediaplayer: MediaPlayer? = null
    private var mediaplayer2: MediaPlayer? = null
    private var playlist = arrayOf(R.raw.duki, R.raw.si_la_calle_llama, R.raw.kemba_walker)
    private var imageslist = arrayOf(R.drawable.bzrp_duki, R.drawable.si_la_calle_llama, R.drawable.kemba)
    private var namelist = arrayOf("DUKI || BZRP Music Sessions #50","Eladio Carrión - Si La Calle Llama (Visualizer) | SEN2 KBRN VOL. 2","Eladio Carrión, Bad Bunny - Kemba Walker (Audio Oficial)")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mediaplayer = MediaPlayer.create(this, playlist[contador]);
        mediaplayer2 = MediaPlayer.create(this, Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-17.mp3"))



        textView = findViewById(R.id.songName)
        //Obtenemos los 5 botones de la interfaz
        btnStream = findViewById(R.id.buttonStreaming)

        btnVideo = findViewById(R.id.buttonVideo)

        btnPlay = findViewById(R.id.buttonPlay)
        btnNext = findViewById(R.id.buttonNext)
        btnPrevius = findViewById(R.id.buttonPrevius)
        imageview = findViewById(R.id.vistaImagenes)
        btnPlay!!.setImageResource(R.drawable.play)





        //Y les asignamos el controlador de eventos
        btnPlay!!.setOnClickListener(this)
        btnNext!!.setOnClickListener(this)
        btnPrevius!!.setOnClickListener(this)
        btnStream!!.setOnClickListener(this)
        btnVideo!!.setOnClickListener(this)

        textView!!.text = namelist[contador]

    }


    override fun onClick(v: View) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente


        when (v.id) {

            R.id.buttonPlay -> {

                btnPlay = findViewById(R.id.buttonPlay)
                //mediaplayer = MediaPlayer.create(this, playlist[contador])
                if (mediaplayer?.isPlaying == true) {
                    mediaplayer!!.pause()
                    btnPlay!!.setImageResource(R.drawable.play)
                } else {
                    btnPlay!!.setImageResource(R.drawable.pause)
                    mediaplayer!!.start()

                }

            }

            R.id.buttonNext -> {
                //mediaplayer = MediaPlayer.create(this, playlist[contador])
                if (contador == playlist.size - 1) {
                    contador = 0
                    mediaplayer!!.stop()
                    mediaplayer!!.prepare()
                    mediaplayer = MediaPlayer.create(this, playlist[contador])
                    mediaplayer!!.seekTo(0)
                    mediaplayer!!.start()
                    btnPlay!!.setImageResource(R.drawable.pause)
                    imageview?.setImageResource(imageslist[contador])
                    textView!!.text = namelist[contador]

                } else {
                    contador++

                    mediaplayer!!.stop()
                    mediaplayer!!.prepare()
                    mediaplayer = MediaPlayer.create(this, playlist[contador])
                    mediaplayer!!.seekTo(0)
                    mediaplayer!!.start()
                    btnPlay!!.setImageResource(R.drawable.pause)
                    mediaplayer!!.start()
                    imageview?.setImageResource(imageslist[contador])
                    textView!!.text = namelist[contador]

                }
            }

            R.id.buttonPrevius -> {
                if (contador == 0) {
                    contador = playlist.size - 1
                    mediaplayer!!.stop()
                    mediaplayer!!.prepare()
                    mediaplayer = MediaPlayer.create(this, playlist[contador])
                    mediaplayer!!.seekTo(0)
                    mediaplayer!!.start()
                    btnPlay!!.setImageResource(R.drawable.pause)
                    mediaplayer!!.start()
                    imageview?.setImageResource(imageslist[contador])
                    textView!!.text = namelist[contador]

                } else {
                    contador -= 1
                    mediaplayer!!.stop()
                    mediaplayer!!.prepare()
                    mediaplayer = MediaPlayer.create(this, playlist[contador])
                    mediaplayer!!.seekTo(0)
                    mediaplayer!!.start()
                    btnPlay!!.setImageResource(R.drawable.pause)
                    mediaplayer!!.start()
                    imageview?.setImageResource(imageslist[contador])
                    textView!!.text = namelist[contador]

                }


            }

            R.id.buttonStreaming ->{
/*
              try {
                    mediaplayer2!!.prepareAsync()
                    mediaplayer2!!.seekTo(0)
                    mediaplayer2!!.start()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
 */
                Toast.makeText(this,
                    "No funciona🥲", Toast.LENGTH_SHORT).show()
            }
            R.id.buttonVideo ->{
                //startActivity(Intent(this, VideoActivity::class.java))
                intent =Intent(this, VideoActivity::class.java).apply {  }
                startActivity(intent)
                if (mediaplayer?.isPlaying == true) {
                    mediaplayer!!.pause()
                    btnPlay!!.setImageResource(R.drawable.play)
                }
            }



        }
    }
}





