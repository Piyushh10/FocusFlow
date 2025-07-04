package com.example.studysmart.domain.use_case

import com.example.studysmart.domain.model.Note
import com.example.studysmart.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}