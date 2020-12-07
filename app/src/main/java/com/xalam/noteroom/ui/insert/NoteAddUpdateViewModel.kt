package com.xalam.noteroom.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.xalam.noteroom.database.Note
import com.xalam.noteroom.repository.NoteRepository

class NoteAddUpdateViewModel(application: Application): ViewModel() {
    private val noteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        noteRepository.insert(note)
    }

    fun update(note: Note) {
        noteRepository.update(note)
    }

    fun delete(note: Note) {
        noteRepository.delete(note)
    }
}