package ge.edu.freeuni.assignment4.presentation.ui.editing

import ge.edu.freeuni.assignment4.presentation.model.NoteModel
import ge.edu.freeuni.assignment4.presentation.model.TodoModel


/*
* created by tgeldiashvili on 5/24/2019
*/

class SingleNotePresenterImpl(
    private var curNote: NoteModel,
    private val view: SingleNoteContract.SingleNoteView,
    private val interactor: SingleNoteContract.SingleNoteInteractor
) :
    SingleNoteContract.SingleNotePresenter {
    override fun saveNote(header: String, allTodoes: ArrayList<TodoModel>) {
        curNote.header = header
        curNote.todoes = allTodoes
        interactor.saveNote(curNote, OnFinishListenerImpl())
    }

    override fun pinNote() {
        curNote.isPinned = !curNote.isPinned
        view.markPinned(curNote.isPinned)
    }

    inner class OnFinishListenerImpl : SingleNoteContract.SingleNoteInteractor.OnFinishListener {
        override fun onFinished() {
            view.goToMain()
        }

    }
}