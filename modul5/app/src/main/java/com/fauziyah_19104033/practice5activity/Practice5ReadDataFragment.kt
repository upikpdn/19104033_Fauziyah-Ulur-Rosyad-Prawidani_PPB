package com.fauziyah_19104033.practice5activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    private lateinit var inputProdi : EditText
    private lateinit var btnProdi : Button
    private lateinit var btnCallBrowser : Button
    private lateinit var btnCallCamera : Button
    private lateinit var inputPhoneNumber : EditText
    private lateinit var btnCallPhone : Button
    private lateinit var btnFragment : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        inputProdi = findViewById(R.id.inputProdi)
        inputPhoneNumber = findViewById(R.id.inputPhoneNumber)

        btnProdi = findViewById(R.id.btnProdi)
        btnCallBrowser = findViewById(R.id.btnCallBrowser)
        btnCallCamera = findViewById(R.id.btnCallCamera)
        btnCallPhone = findViewById(R.id.btnCallPhone)
        btnFragment = findViewById(R.id.btnFragment)

        btnProdi.setOnClickListener {
            val namaProdi = inputProdi.text.toString()
            if (namaProdi.isEmpty()) {
                inputProdi.error = "Prodi Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val moveWithDataIntent = Intent(this@MainActivity, MainActivityReadData::class.java)
            moveWithDataIntent.putExtra(MainActivityReadData.EXTRA_PRODI, namaProdi)
            startActivity(moveWithDataIntent)
        }

        // membuka web ittp
        btnCallBrowser.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://ittelkom-pwt.ac.id/")
            startActivity(intent)
        }

        btnCallCamera.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btnCallPhone.setOnClickListener{
            val phoneNumber = inputPhoneNumber.getText()
            if (phoneNumber.isEmpty()) {
                inputPhoneNumber.error = "Nomor Telpon Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + phoneNumber)
            startActivity(intent)
        }

        setupPermissions()

        btnFragment.setOnClickListener{
            val intent = Intent(this, Pratice5ForFragmentActivity::class.java)
            startActivity(intent)
        }
    }


    val CALL_REQUEST_CODE = 100
    @SuppressLint("MissingPermission")
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_REQUEST_CODE)
        }
    }


}