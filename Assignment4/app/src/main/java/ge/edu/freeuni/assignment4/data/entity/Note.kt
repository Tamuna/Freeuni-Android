package ge.edu.freeuni.assignment4.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/*
* created by tgeldiashvili on 5/22/2019
*/

@Entity
data class Note(
    @PrimaryKey val id: Int,
    val isPinned: Boolean?,
    val header: String?,
    val todoes: List<Todo>?
)