package ge.edu.freeuni.assignment4.presentation.ui.notes

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.presentation.model.NoteModel


/*
* created by tgeldiashvili on 5/22/2019
*/

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.tvNoteHeader)
    lateinit var tvNoteHeader: TextView

    @BindView(R.id.layoutTodoes)
    lateinit var layoutTodoes: LinearLayout

    @BindView(R.id.txtNumChecked)
    lateinit var txtNumChecked: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun setData(
        onItemClickedListener: MainRecyclerAdapter.OnItemClickedListener,
        noteModel: NoteModel,
        context: Context
    ) {
        itemView.setOnClickListener(View.OnClickListener { onItemClickedListener.onNoteItemClicked(noteModel) })
        tvNoteHeader.text = noteModel.header
        layoutTodoes.removeAllViews()
        noteModel.todoes.map {
            if (!it.isDone) {
                val singleTodo = TodoComponent(context)
                singleTodo.setTodo(it.content)
                layoutTodoes.addView(singleTodo)
            }
        }

        if (noteModel.checkedNumber > 0) {
            txtNumChecked.text = "+${noteModel.checkedNumber} ticked items"
        } else {
            txtNumChecked.visibility = View.GONE
        }

    }
}