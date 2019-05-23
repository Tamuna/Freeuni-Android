package ge.edu.freeuni.assignment4.ui.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ge.edu.freeuni.assignment4.ui.model.NoteModel
import ge.edu.freeuni.assignment4.R

class MainActivity : AppCompatActivity(), MainContract.MainView {
    override fun onNotesLoaded(data: ArrayList<Any>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openNote(noteModel: NoteModel) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
