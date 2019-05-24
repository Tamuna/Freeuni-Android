package ge.edu.freeuni.assignment4.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import ge.edu.freeuni.assignment4.data.database.AppDatabase


/*
* created by tgeldiashvili on 5/24/2019
*/

open class BaseActivity: AppCompatActivity() {
    val appDatabase: AppDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "Notes").build()
}