package ge.edu.freeuni.assignment4.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


/*
* created by tgeldiashvili on 5/22/2019
*/

@Entity(
    foreignKeys = [ForeignKey(
        entity = Note::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("note_id"),
        onDelete = CASCADE

    )]
)
data class Todo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "note_id") val noteId: Int,
    val isDone: Boolean?,
    val content: String?
)