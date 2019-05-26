package ge.edu.freeuni.assignment4.presentation.ui.notes

import ge.edu.freeuni.assignment4.presentation.model.NoteModel


/*
* created by tgeldiashvili on 5/23/2019
*/

interface MainContract {
    interface MainView {
        fun onNotesLoaded(data: List<NoteModel>)
    }

    interface MainPresenter {
        fun loadNotes()
    }

    interface MainInteractor {
        interface OnFinishListener {
            fun onDataLoaded(noteModels: List<NoteModel>)
        }

        fun loadNotes(onFinishListener: OnFinishListener)
    }
}