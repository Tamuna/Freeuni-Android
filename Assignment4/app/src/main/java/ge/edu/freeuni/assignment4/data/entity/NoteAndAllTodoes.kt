package ge.edu.freeuni.assignment4.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class NoteAndAllTodoes(
    @Embedded
    val note: NoteEntity,

    @Relation(
        parentColumn = "id", entityColumn = "noteId", entity = TodoEntity::class
    )
    val todoes: List<TodoEntity>?
)