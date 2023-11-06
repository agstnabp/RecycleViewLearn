package com.example.recycleviewlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycleviewlearn.databinding.ActivityDetailsBinding
import com.example.recycleviewlearn.databinding.ActivityMainBinding

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var beachphoto = intent.getIntExtra("Beach image",0)
        var beachname = intent.getStringExtra("Beach name")
        var contentbeach = intent.getStringExtra("Beach content")

        with(binding){
            gambarPantai.setImageResource(beachphoto)
            namaPantai.text=beachname
            konten.text=contentbeach
        }
    }
}