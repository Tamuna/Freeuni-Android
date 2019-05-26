package ge.edu.freeuni.assignment4.presentation.ui.editing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.presentation.model.NoteModel
import ge.edu.freeuni.assignment4.presentation.model.TodoModel
import ge.edu.freeuni.assignment4.presentation.ui.notes.MainActivity

class SingleNoteActivity : AppCompatActivity(), SingleNoteContract.SingleNoteView {

    @BindView(R.id.imgPin)
    lateinit var imgPin: ImageView

    @BindView(R.id.rvTodoes)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.etNoteHeader)
    lateinit var etNoteHeader: EditText

    private lateinit var presenter: SingleNotePresenterImpl
    private var note: NoteModel? = null
    private lateinit var adapter: SingleNoteRecyclerAdapter

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

        note = intent.getParcelableExtra<NoteModel?>(NOTE)

        if (note == null) {
            note = NoteModel(false, "", 0, arrayListOf(TodoModel(false, "", -1)), -1)
        }

        presenter = SingleNotePresenterImpl(note!!, this, SingleNoteInteractorImpl(this))

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = SingleNoteRecyclerAdapter(OnItemClickListenerImpl())
        adapter.setData(note!!.todoes, note!!.checkedNumber)
        recyclerView.adapter = adapter
        etNoteHeader.setText(note!!.header)
        markPinned(note!!.isPinned)

    }

    private fun getAllNotes(): ArrayList<TodoModel> {
        val allTodoes: ArrayList<TodoModel> = ArrayList()
        val data: List<Any> = adapter.getTodoes()
        for (i in 0 until data.size) {
            if (data[i] is TodoModel) {
                val view: View = recyclerView.getChildAt(i)
                allTodoes.add(
                    TodoModel(
                        ((view as ConstraintLayout).getChildAt(0) as CheckBox).isChecked,
                        (view.getChildAt(1) as EditText).text.toString(),
                        (data[i] as TodoModel).id
                    )
                )
            }
        }
        return allTodoes
    }

    @OnClick(R.id.imgBack)
    fun onBackClicked() {
        presenter.saveNote(etNoteHeader.text.toString(), getAllNotes())

    }

    @OnClick(R.id.imgPin)
    fun onPinClicked() {
        presenter.pinNote()
    }


    override fun goToMain() {
        finish()
    }

    override fun markPinned(isPinned: Boolean) {
        if (isPinned) {
            imgPin.setImageResource(R.drawable.pinned)
        } else {
            imgPin.setImageResource(R.drawable.pin)
        }
    }

    inner class OnItemClickListenerImpl : SingleNoteRecyclerAdapter.OnItemClickListener {
        override fun onTodoChecked() {
            val allTodoes = getAllNotes()
            adapter.setData(allTodoes.sortedBy { it.isDone }, allTodoes.count { it.isDone })
        }

        override fun onAddItemClicked() {
            val allTodoes = getAllNotes()
            allTodoes.add(TodoModel(false, "", -1))
            adapter.setData(allTodoes.sortedBy { it.isDone }, allTodoes.count { it.isDone })
        }
    }
}
