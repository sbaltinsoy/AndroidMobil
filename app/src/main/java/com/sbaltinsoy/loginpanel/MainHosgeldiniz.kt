package com.sbaltinsoy.loginpanel

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sbaltinsoy.loginpanel.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {

    private lateinit var binding: ActivityMainHosgeldinizBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // xml veriler cekilir
        preferences = getSharedPreferences("bilgiler", Context.MODE_PRIVATE)

        var kayitliKullanici = preferences.getString("kullanici","")
        var kayitliParola = preferences.getString("parola","")
        //
        binding.textViewKullaniciAdi.text = "Kullanici adi : "+kayitliKullanici.toString()
        binding.textViewKullaniciParola.text="Kullanici Parolasi : "+kayitliParola.toString()

        binding.btnCikis.setOnClickListener{
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }
    }
}