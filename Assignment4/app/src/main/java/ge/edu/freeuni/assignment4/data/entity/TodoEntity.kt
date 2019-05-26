package ge.edu.freeuni.assignment4.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/*
* created by tgeldiashvili on 5/22/2019
*/

@Entity
class TodoEntity(
    val isDone: Boolean?,
    val content: String?

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var noteId: Long? = null
}