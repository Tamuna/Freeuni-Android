package ge.edu.freeuni.assignment4.ui.editing


/*
* created by tgeldiashvili on 5/23/2019
*/

interface SingleNoteContract {
    interface SingleNoteView {
        fun goToMain()
        fun markPinned()
    }

    interface SingleNotePresenter {
        fun saveNote()
        fun pinNote()
    }

    interface SingleNoteInteractor {
        interface OnFinishListener {
            fun onFinished()
        }

        fun saveNote()
        fun pinNote()
    }
}