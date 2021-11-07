package com.fauziyah_19104033.helloittelkompurwokerto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun printState(msg: String){
        Log.d = Log.d("ActivityState", msg) //logcat, muncul di logcat android studio
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show() //toast, muncul di UI APP
    }

    override fun onStart(){
        super.onStart()
        printState("Halaman satu On Start")
    }
    override fun onResume(){
        super.onResume()
        printState("Halaman satu On Resume")
    }
    override fun onPause(){
        super.onPause()
        printState("Halaman satu On Pause")
    }
    override fun onStop(){
        super.onStop()
        printState("Halaman satu On Stop")
    }
    override fun onRestart(){
        super.onRestart()
        printState("Halaman satu On Restart")
    }
    override fun onDestroy() {
        super.onDestroy()
        printState("Halaman satu On Destroy")
    }

    btnPage.setOnClickListener{
        val intent = Intent(this, HalamanDuaActivity::class.java)
        startActivity(intent)
    }

}