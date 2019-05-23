package ge.edu.freeuni.assignment4.ui.notes

import ge.edu.freeuni.assignment4.ui.model.NoteModel


/*
* created by tgeldiashvili on 5/23/2019
*/

interface MainContract {
    interface MainView {
        fun openNote(noteModel: NoteModel)
        fun onNotesLoaded(data: ArrayList<Any>)
    }

    interface MainPresenter {
        fun loadNotes()
    }

    interface MainInteractor {
        interface OnFinishListener {
            fun onDataLoaded()
        }
        fun loadNotes()
    }
}