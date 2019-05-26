package ge.edu.freeuni.assignment4.presentation.ui.notes

import ge.edu.freeuni.assignment4.presentation.model.NoteModel

class MainPresenterImpl(private val view: MainContract.MainView, private val interactor: MainContract.MainInteractor) :
    MainContract.MainPresenter {


    override fun loadNotes() {
        interactor.loadNotes(OnFinishListenerImpl())
    }

    inner class OnFinishListenerImpl : MainContract.MainInteractor.OnFinishListener {
        override fun onDataLoaded(noteModels: List<NoteModel>) {
            view.onNotesLoaded(noteModels)
        }
    }
}