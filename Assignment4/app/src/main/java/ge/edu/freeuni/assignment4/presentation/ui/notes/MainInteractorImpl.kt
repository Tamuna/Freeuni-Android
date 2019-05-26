package ge.edu.freeuni.assignment4.presentation.ui.notes

import android.content.Context
import ge.edu.freeuni.assignment4.presentation.ui.BaseInteractor

class MainInteractorImpl(context: Context) : MainContract.MainInteractor, BaseInteractor(context) {
    override fun loadNotes(onFinishListerner: MainContract.MainInteractor.OnFinishListener) {
        LoadTask(appDatabase, onFinishListerner).execute()
    }
}