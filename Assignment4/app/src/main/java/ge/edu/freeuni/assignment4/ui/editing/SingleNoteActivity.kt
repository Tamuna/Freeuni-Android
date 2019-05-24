package ge.edu.freeuni.assignment4.ui.editing

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.ui.model.NoteModel
import ge.edu.freeuni.assignment4.ui.notes.MainActivity

class SingleNoteActivity : AppCompatActivity(), SingleNoteContract.SingleNoteView {

    @BindView(R.id.imgPin)
    lateinit var imgPin: ImageView

    companion object {
        private const val NOTE = "note"

        @JvmStatic
        fun start(previous: Context, note: NoteModel) {
            val intent = Intent(previous, SingleNoteActivity::class.java)
            intent.putExtra(NOTE, note)
            previous.startActivity(intent)
        }

        fun start(previous: Context) {
            val intent = Intent(previous, SingleNoteActivity::class.java)
            previous.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)
        ButterKnife.bind(this)

        val note = intent.getParcelableExtra<NoteModel>(NOTE)
        if(note != null){

        }
    }

    @OnClick(R.id.imgBack)
    fun onBackClicked() {
        //presenter.saveNote()
    }


    override fun goToMain() {
        MainActivity.start(this)
    }

    override fun markPinned() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
