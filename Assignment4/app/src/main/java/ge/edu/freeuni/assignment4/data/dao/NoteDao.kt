package ge.edu.freeuni.assignment4.data.dao

import androidx.room.*
import ge.edu.freeuni.assignment4.data.entity.Note


/*
* created by tgeldiashvili on 5/22/2019
*/

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Delete
    fun delete(note: Note)
}