package com.example.searchlistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchlistapp.databinding.ItemNoteBinding

class NoteAdapter(private val noteList: ArrayList<Note>) : RecyclerView.Adapter<NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = ItemNoteBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
       return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = noteList[position]
        holder.bind(currentItem)
    }

    fun updateList(list: ArrayList<Note>) {
        noteList.clear()
        noteList.addAll(list)
        notifyDataSetChanged()
    }
}

class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {


    fun bind(note: Note) {
        binding.title.text = note.id.toString()
        binding.subtitle.text = note.name.toString()
    }

}