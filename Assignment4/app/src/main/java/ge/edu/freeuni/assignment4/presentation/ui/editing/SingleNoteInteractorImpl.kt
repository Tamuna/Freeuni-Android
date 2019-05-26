package ge.edu.freeuni.assignment4.presentation.ui.editing

import android.content.Context
import ge.edu.freeuni.assignment4.presentation.model.NoteModel
import ge.edu.freeuni.assignment4.presentation.ui.BaseInteractor


/*
* created by tgeldiashvili on 5/24/2019
*/

class SingleNoteInteractorImpl(val context: Context) : SingleNoteContract.SingleNoteInteractor,
    BaseInteractor(context) {

    override fun saveNote(
        note: NoteModel,
        onFinishListener: SingleNoteContract.SingleNoteInteractor.OnFinishListener
    ) {
       InsertTask(appDatabase, onFinishListener, note).execute()
    }
}