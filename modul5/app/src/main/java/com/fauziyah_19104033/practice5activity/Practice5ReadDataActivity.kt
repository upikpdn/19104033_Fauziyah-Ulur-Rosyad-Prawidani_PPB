package com.fauziyah_19104033.practice5activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivityReadData : AppCompatActivity(){

    private lateinit var lblProdiSaya : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_read_data)
        
        lblProdiSaya = findViewById(R.id.lblProdiSaya)

        val prodi = intent.getStringExtra(EXTRA_PRODI)
        lblProdiSaya.text = "Prodi Saya Adalah $prodi"
    }

    companion object {
        const val EXTRA_PRODI = "extra_prodi"
    }

}