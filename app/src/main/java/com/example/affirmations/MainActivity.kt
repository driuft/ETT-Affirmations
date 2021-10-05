package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Store list of affirmations in a variable
        val myDataset = Datasource().loadAffirmations()
        // Store instance of recyclerview from XML layout
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        
        // Point recyclerview to adapter, passing context and data list
        recyclerView.adapter = ItemAdapter(this, myDataset)
        // Set fixed size to improve performance
        recyclerView.setHasFixedSize(true)
    }
}