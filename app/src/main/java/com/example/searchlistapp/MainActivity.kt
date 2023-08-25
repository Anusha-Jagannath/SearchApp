package com.example.searchlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchlistapp.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteList: ArrayList<Note>
    private lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        noteList = arrayListOf()
        setUpRecyclerView()
        noteList = Utils.getData()
        adapter.updateList(noteList)

        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val queryText = newText.toString().lowercase().trim()
                val searchList = arrayListOf<Note>()
                if (queryText.isNotEmpty()) {

                    for (data in noteList) {
                        if (data.name.lowercase(Locale.ROOT).contains(queryText)) {
                            searchList.add(data)
                        }
                    }

                   if (!searchList.isEmpty()) {
                      adapter.updateList(searchList)
                   } else {
                       Toast.makeText(this@MainActivity,"empty data", Toast.LENGTH_SHORT).show()
                   }

                } else {
                    adapter.updateList(noteList)
                }

                return true
            }

        })
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NoteAdapter(noteList)
        binding.recyclerView.adapter = adapter
    }


}