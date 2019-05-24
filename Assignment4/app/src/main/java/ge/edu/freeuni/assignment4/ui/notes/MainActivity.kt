package ge.edu.freeuni.assignment4.ui.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.ui.editing.SingleNoteActivity
import ge.edu.freeuni.assignment4.ui.model.NoteModel

class MainActivity : AppCompatActivity(), MainContract.MainView {

    @OnClick(R.id.tvTakeNote)
    fun onTakeNoteClick() {
        SingleNoteActivity.start(this)
    }

    companion object {
        fun start(previous: Context) {
            val intent = Intent(previous, MainActivity::class.java)
            previous.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)
    }

    override fun onNotesLoaded(data: ArrayList<Any>) {

    }

    override fun openNote(noteModel: NoteModel) {

    }


}
