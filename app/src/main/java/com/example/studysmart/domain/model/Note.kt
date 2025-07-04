package com.example.studysmart.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.studysmart.presentation.theme.color1
import com.example.studysmart.presentation.theme.color2
import com.example.studysmart.presentation.theme.color3
import com.example.studysmart.presentation.theme.color4
import com.example.studysmart.presentation.theme.color5
import com.example.studysmart.presentation.theme.color6
import com.example.studysmart.presentation.theme.color7
import com.example.studysmart.presentation.theme.color8

// Domain model for a Note


@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(color1, color2, color3, color4, color5, color6, color7, color8)
    }
}

class InvalidNoteException(message: String): Exception(message)