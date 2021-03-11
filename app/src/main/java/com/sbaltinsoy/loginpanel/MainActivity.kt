package com.sbaltinsoy.loginpanel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sbaltinsoy.loginpanel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("bilgiler", Context.MODE_PRIVATE)

        binding.buttonGiris.setOnClickListener{
            var kayitliKullanici = preferences.getString("kullanici","")
            var kayitliParola = preferences.getString("parola","")

            var girisKullanici = binding.editTextTextPersonName.text.toString()
            var girisParola = binding.editTextTextPersonPassword.text.toString()

            if((kayitliKullanici == girisKullanici)&&(kayitliParola==girisParola)){
                intent = Intent(applicationContext,MainHosgeldiniz::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Giris Bilgileri Hatali",Toast.LENGTH_LONG).show()
            }


        }
        binding.buttonKayit.setOnClickListener{
            intent = Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        }

    }
}