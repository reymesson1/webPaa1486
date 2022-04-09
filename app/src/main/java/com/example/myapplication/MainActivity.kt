package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import okio.ByteString
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {

            start()

        }


//        client = OkHttpClient()


//        val request = Request.Builder()
//            .url("ws://10.0.0.105:8080")
//            .build()
////
//        val listener = EchoWebSocketListener()

//        val webSocket = httpClient.newWebSocket(request, listener)
        //webSocket.
//        httpClient.dispatcher.executorService.shutdown()

//        val client = OkHttpClient.Builder()
//            .readTimeout(3, TimeUnit.SECONDS)
//            //.sslSocketFactory() - ? нужно ли его указывать дополнительно
//            .build()
//
//        val request = Request.Builder()
//            .url("ws://10.0.0.105:8080") // 'wss' - для защищенного канала
//            .build()
//        val wsListener = EchoWebSocketListener ()
//        val webSocket = client.newWebSocket(request, wsListener) // this provide to make 'Open ws connection'


    }

    private fun start() {
        val request: Request = Request.Builder().url("ws://10.0.0.105:8080/").build()
        val listener: EchoWebSocketListener = EchoWebSocketListener()
        val ws: WebSocket = client.newWebSocket(request, listener)
        client.dispatcher().executorService().shutdown()
    }

}

