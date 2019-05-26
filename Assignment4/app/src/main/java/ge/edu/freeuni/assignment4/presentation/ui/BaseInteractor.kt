package ge.edu.freeuni.assignment4.presentation.ui

import android.content.Context
import android.os.AsyncTask
import androidx.room.Room
import ge.edu.freeuni.assignment4.data.database.AppDatabase
import ge.edu.freeuni.assignment4.data.entity.NoteAndAllTodoes
import ge.edu.freeuni.assignment4.data.entity.mapper.toEntity
import ge.edu.freeuni.assignment4.data.entity.mapper.toModel
import ge.edu.freeuni.assignment4.presentation.model.NoteModel
import ge.edu.freeuni.assignment4.presentation.ui.editing.SingleNoteContract
import ge.edu.freeuni.assignment4.presentation.ui.notes.MainContract

open class BaseInteractor(private val context: Context) {
    var appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "Notes").build()

    class InsertTask(
        private val appDatabase: AppDatabase,
        private val onFinishListener: SingleNoteContract.SingleNoteInteractor.OnFinishListener,
        private val note: NoteModel
    ) :
        AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void?): Void? {
            val noteAndAllTodoes: NoteAndAllTodoes = note.toEntity()

            val id = appDatabase.noteDao().insertNote(noteAndAllTodoes.note)
            noteAndAllTodoes.todoes?.map {
                it.noteId = id
                appDatabase.noteDao().insertTodo(it)
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            onFinishListener.onFinished()
        }
    }

    class LoadTask(
        private val appDatabase: AppDatabase,
        private val onFinishListener: MainContract.MainInteractor.OnFinishListener
    ) : AsyncTask<Void, Void, List<NoteAndAllTodoes>>() {
        override fun doInBackground(vararg params: Void?): List<NoteAndAllTodoes> {
            return appDatabase.noteDao().getAll()
        }

        override fun onPostExecute(result: List<NoteAndAllTodoes>) {
            val resultNotes = result.map { it.toModel() }
            resultNotes.map {
                it.todoes = it.todoes.sortedBy { it1 -> it1.isDone }
            }
            onFinishListener.onDataLoaded(resultNotes.sortedBy { it.isPinned }.reversed())
        }
    }
}

