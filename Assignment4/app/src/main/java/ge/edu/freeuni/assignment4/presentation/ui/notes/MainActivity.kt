package ge.edu.freeuni.assignment4.presentation.ui.notes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.presentation.model.NoteModel
import ge.edu.freeuni.assignment4.presentation.ui.editing.SingleNoteActivity


class MainActivity : AppCompatActivity(), MainContract.MainView {


    private lateinit var presenter: MainPresenterImpl
    private lateinit var adapter: MainRecyclerAdapter

    @OnClick(R.id.tvTakeNote)
    fun onTakeNoteClick() {
        SingleNoteActivity.start(this)
    }

    @BindView(R.id.rvNotes)
    lateinit var rvNotes: RecyclerView

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

        presenter = MainPresenterImpl(this, MainInteractorImpl(this))
        adapter = MainRecyclerAdapter(this, OnItemClickedListenerImpl())
        rvNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvNotes.adapter = adapter
        presenter.loadNotes()
    }

    override fun onNotesLoaded(data: List<NoteModel>) {
        adapter.setData(data)
    }

    inner class OnItemClickedListenerImpl : MainRecyclerAdapter.OnItemClickedListener {
        override fun onNoteItemClicked(noteModel: NoteModel) {
            SingleNoteActivity.start(this@MainActivity, noteModel)
        }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onResume() {
        presenter.loadNotes()
        super.onResume()
    }
}
