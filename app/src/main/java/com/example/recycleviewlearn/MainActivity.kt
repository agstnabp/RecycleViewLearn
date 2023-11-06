package com.example.recycleviewlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleviewlearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterBeach = BeachAdapter(generateDummy()){ beach ->
            val beachintent = Intent(this@MainActivity, Details::class.java)
            beachintent.putExtra("Beach image", beach.image)
            beachintent.putExtra("Beach name", beach.nameBeach)
            beachintent.putExtra("Beach date", beach.typeDate)
            beachintent.putExtra("Beach content", beach.description)

            startActivity(beachintent)
        }
        with(binding){
            rvDisaster.apply{
                adapter = adapterBeach
                layoutManager = GridLayoutManager(this@MainActivity, 1)
            }
        }
    }

    fun generateDummy(): List<Beach> {
        return listOf(
            Beach(image = R.drawable.karimunjawa, nameBeach = "Karimunjawa", typeDate = "24 December 2019", description = R.string.karimunjawa.toString()),
            Beach(image = R.drawable.labuanbajo, nameBeach = "Labuan Bajo", typeDate = "15 April 2020", description = R.string.labuanbajo.toString()),
            Beach(image = R.drawable.pantaipink, nameBeach = "Pantai Pink", typeDate = "20 June 2021", description = R.string.pantaipink.toString()),
            Beach(image = R.drawable.pantaikuta, nameBeach = "Pantai Kuta", typeDate = "10 April 2023", description = R.string.pantaikuta.toString()),
            Beach(image = R.drawable.pantaipink, nameBeach = "Pantai Pink", typeDate = "20 June 2021", description = R.string.pantaipink.toString()),
            Beach(image = R.drawable.pantaikuta, nameBeach = "Pantai Kuta", typeDate = "10 April 2023", description = R.string.pantaikuta.toString())
        )
    }
}