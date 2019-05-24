package ge.edu.freeuni.assignment4.ui.editing

import ge.edu.freeuni.assignment4.ui.model.NoteModel


/*
* created by tgeldiashvili on 5/24/2019
*/

class SingleNotePresenterImpl(
    private val curNote: NoteModel,
    private val view: SingleNoteContract.SingleNoteView,
    private val interactor: SingleNoteContract.SingleNoteInteractor
) :
    SingleNoteContract.SingleNotePresenter {

    override fun saveNote() {
        interactor.saveNote(curNote, OnFinishListenerImpl())
    }

    override fun pinNote() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class OnFinishListenerImpl : SingleNoteContract.SingleNoteInteractor.OnFinishListener {
        override fun onFinished() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}