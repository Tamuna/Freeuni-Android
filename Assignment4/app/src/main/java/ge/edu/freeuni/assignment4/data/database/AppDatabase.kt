package ge.edu.freeuni.assignment4.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ge.edu.freeuni.assignment4.data.dao.NoteDao
import ge.edu.freeuni.assignment4.data.entity.NoteEntity
import ge.edu.freeuni.assignment4.data.entity.TodoEntity


/*
* created by tgeldiashvili on 5/22/2019
*/

@Database(entities = arrayOf(NoteEntity::class, TodoEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}