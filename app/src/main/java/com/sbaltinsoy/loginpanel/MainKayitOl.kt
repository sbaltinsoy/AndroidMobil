package com.sbaltinsoy.loginpanel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sbaltinsoy.loginpanel.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonKaydet.setOnClickListener{
            var kullaniciBilgisi = binding.editTextKayitTextPersonName.text.toString()
            var kullaniciParola = binding.editTextKayitTextPersonPassword.text.toString()
            var SharedPreferences = this.getSharedPreferences("bilgiler", Context.MODE_PRIVATE)
            var editor = SharedPreferences.edit()

            editor.putString("kullanici","$kullaniciBilgisi").apply()
            editor.putString("parola","$kullaniciParola").apply()

            Toast.makeText(applicationContext,"Kayit Basarili",Toast.LENGTH_LONG).show()

            binding.editTextKayitTextPersonName.text.clear()
            binding.editTextKayitTextPersonPassword.text.clear()
        }




        binding.buttonGiriseDon.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }

    }
}