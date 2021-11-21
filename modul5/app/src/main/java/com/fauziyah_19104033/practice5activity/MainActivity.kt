package com.fauziyah_19104033.practice5activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnProdi.setOnClickListener {
                val namaProdi = inputProdi.text.toString()

                if (namaProdi.isEmpty()){
                    inputProdi.error = "Prodi Tidak Boleh Kosong"
                    return@setOnClickListener
                }

                val moveWithDataIntent = Intent(this@MainActivity, Practice5ReadDataActivity::class.java)
                moveWithDataIntent.putExtra(Practice5ReadDataActivity.EXTRA_PRODI, namaProdi)
                startActivity(moveWithDataIntent)
            }

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

            btnFragment.setOnClickListener {
                startActivity(Intent(this@MainActivity, Practice5ForFragmentActivity::class.java))
            }

        }
        setupPermissions()
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