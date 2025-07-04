package com.example.studysmart.domain.use_case

import com.example.studysmart.presentation.notes.NotesEvent

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getNote: GetNote
)