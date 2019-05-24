package ge.edu.freeuni.assignment4.ui.editing

import ge.edu.freeuni.assignment4.ui.model.NoteModel


/*
* created by tgeldiashvili on 5/23/2019
*/

interface SingleNoteContract {
    interface SingleNoteView {
        fun goToMain()
        fun markPinned(isPinned: Boolean)
    }

    interface SingleNotePresenter {
        fun saveNote()
        fun pinNote()
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