package com.example.studysmart.presentation.notes

import com.example.studysmart.domain.model.Note
import com.example.studysmart.util.NoteOrder
import com.example.studysmart.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)