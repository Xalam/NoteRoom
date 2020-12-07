package com.xalam.noteroom.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.xalam.noteroom.database.Note
import com.xalam.noteroom.repository.NoteRepository

class MainViewModel(application: Application):ViewModel() {
    private val noteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = noteRepository.getAllNotes()
}