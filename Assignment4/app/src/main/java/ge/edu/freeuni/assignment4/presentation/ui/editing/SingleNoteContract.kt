package ge.edu.freeuni.assignment4.presentation.ui.editing

import ge.edu.freeuni.assignment4.presentation.model.NoteModel
import ge.edu.freeuni.assignment4.presentation.model.TodoModel


/*
* created by tgeldiashvili on 5/23/2019
*/

interface SingleNoteContract {
    interface SingleNoteView {
        fun goToMain()
        fun markPinned(isPinned: Boolean)
    }

    interface SingleNotePresenter {
        fun pinNote()
        fun saveNote(header: String, allNotes: ArrayList<TodoModel>)
    }

    interface SingleNoteInteractor {
        interface OnFinishListener {
            fun onFinished()
        }

        fun saveNote(
            note: NoteModel,
            onFinishListener: OnFinishListener
        )
    }
}