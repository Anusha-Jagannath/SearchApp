package com.example.searchlistapp

object Utils {


    fun getData(): ArrayList<Note> {
        val noteList = arrayListOf<Note>()
        noteList.add(Note(1,"jkl"))
        noteList.add(Note(2,"nmk"))
        noteList.add(Note(3,"tyu"))

        noteList.add(Note(1,"jkl"))
        noteList.add(Note(2,"nmk"))
        noteList.add(Note(3,"tyu"))

        noteList.add(Note(1,"jkl"))
        noteList.add(Note(2,"nmk"))
        noteList.add(Note(3,"tyu"))
        return noteList
    }
}