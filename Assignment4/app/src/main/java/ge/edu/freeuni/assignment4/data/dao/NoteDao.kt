package ge.edu.freeuni.assignment4.data.dao

import androidx.room.*
import ge.edu.freeuni.assignment4.data.entity.NoteAndAllTodoes
import ge.edu.freeuni.assignment4.data.entity.NoteEntity
import ge.edu.freeuni.assignment4.data.entity.TodoEntity


/*
* created by tgeldiashvili on 5/22/2019
*/

@Dao
interface NoteDao {
    @Query("SELECT * FROM NoteEntity")
    fun getAll(): List<NoteAndAllTodoes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todoEntity: TodoEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

}