package ge.edu.freeuni.assignment4.data.dao

import androidx.room.*
import ge.edu.freeuni.assignment4.data.entity.NoteEntity


/*
* created by tgeldiashvili on 5/22/2019
*/

@Dao
interface NoteDao {
    @Query("SELECT * FROM NoteEntity")
    fun getAll(): List<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Update
    fun update(noteEntity: NoteEntity)
}