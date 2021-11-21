package com.fauziyah_19104033.practice5activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Practice5FirstFragment : Fragment() {

    private lateinit var binding : FragmentPractice5FirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPractice5FirstBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnToSecondFragment.setOnClickListener {
                val nama = inputNama.text.toString()
                if (nama.isEmpty()){
                    inputNama.error = "Nama Tidak Boleh Kosong"
                    return@setOnClickListener
                }

                val nim = inputNim.text.toString()
                if (nim.isEmpty()){
                    inputNim.error = "Nim Tidak Boleh Kosong"
                    return@setOnClickListener
                }

                val mReadDataFragment = Practice5ReadDataFragment()
                val mBundle = Bundle()
                mBundle.putString(Practice5ReadDataFragment.EXTRA_NAMA, nama)
                mReadDataFragment.arguments = mBundle
                mReadDataFragment.nim = nim.toInt()

                val mFragmentManager = fragmentManager as FragmentManager
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, mReadDataFragment, Practice5ReadDataFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {

    }
}