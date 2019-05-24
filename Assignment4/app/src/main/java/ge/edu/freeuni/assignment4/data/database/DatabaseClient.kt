package ge.edu.freeuni.assignment4.data.database

import android.content.Context
import androidx.room.Room


/*
* created by tgeldiashvili on 5/24/2019
*/

class DatabaseClient private constructor(private val context: Context) {
    val appDatabase: AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "Notes").build()

    companion object {
        private var dbInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(context: Context): DatabaseClient {
            dbInstance?.let {
                return it
            }
            return DatabaseClient(context)
        }
    }
}