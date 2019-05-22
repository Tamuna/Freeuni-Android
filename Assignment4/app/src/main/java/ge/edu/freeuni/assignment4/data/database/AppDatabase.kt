package ge.edu.freeuni.assignment4.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ge.edu.freeuni.assignment4.data.dao.NoteDao
import ge.edu.freeuni.assignment4.data.entity.Note
import ge.edu.freeuni.assignment4.data.entity.Todo


/*
* created by tgeldiashvili on 5/22/2019
*/

@Database(entities = arrayOf(Note::class, Todo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}