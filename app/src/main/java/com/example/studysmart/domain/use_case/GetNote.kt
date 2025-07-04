package com.example.studysmart.domain.use_case

import com.example.studysmart.domain.model.Note
import com.example.studysmart.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}