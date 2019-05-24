package ge.edu.freeuni.assignment4.ui.editing

import ge.edu.freeuni.assignment4.data.dao.NoteDao
import ge.edu.freeuni.assignment4.data.entity.mapper.toEntity
import ge.edu.freeuni.assignment4.ui.model.NoteModel


/*
* created by tgeldiashvili on 5/24/2019
* https://www.simplifiedcoding.net/android-room-database-example/
*/

class SingleNoteInteractorImpl(private val dao: NoteDao) : SingleNoteContract.SingleNoteInteractor {

    override fun saveNote(
        note: NoteModel,
        onFinishListener: SingleNoteContract.SingleNoteInteractor.OnFinishListener
    ) {
        dao.insertNote(note.toEntity())
        onFinishListener.onFinished()
    }
}