package com.xalam.noteroom.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.xalam.noteroom.database.Note
import com.xalam.noteroom.database.NoteDao
import com.xalam.noteroom.database.NoteDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val noteDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val database = NoteDatabase.getDatabase(application)
        noteDao = database.noteDao()
    }

    fun getAllNotes(): LiveData<List<Note>> = noteDao.getAllNotes()

    fun insert(note: Note) {
        executorService.execute { noteDao.insert(note) }
    }

    fun delete(note: Note) {
        executorService.execute { noteDao.delete(note) }
    }

    fun update(note: Note) {
        executorService.execute { noteDao.update(note) }
    }
}