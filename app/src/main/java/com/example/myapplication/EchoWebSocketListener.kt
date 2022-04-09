package com.example.myapplication

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import org.jetbrains.anko.doAsync

class EchoWebSocketListener : WebSocketListener() {
    private var NORMAL_CLOSURE_STATUS: Int = 1000

    override fun onOpen(webSocket: WebSocket, response: Response) {
        webSocket.send("Hola there!")
        webSocket.send("cool")
        webSocket.close(NORMAL_CLOSURE_STATUS,"GoodBye!!")
    }

    override fun onMessage(webSocket: WebSocket, text: String){
        super.onMessage(webSocket, text)
        output("Receiving $text")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        output("Closing : "+ code + "/" + reason)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        output("Error : " + t.message)
    }


    private fun output(s: String) {
        Log.i("response", s)
    }
}