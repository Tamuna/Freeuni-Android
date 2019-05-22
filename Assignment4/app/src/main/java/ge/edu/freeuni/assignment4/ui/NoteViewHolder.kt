package ge.edu.freeuni.assignment4.ui

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.data.entity.Note


/*
* created by tgeldiashvili on 5/22/2019
*/

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.tvNoteHeader)
    lateinit var tvNoteHeader: TextView

    @BindView(R.id.layoutTodoes)
    lateinit var layoutTodoes: LinearLayout

    init {
        ButterKnife.bind(this, itemView)
    }

    fun setData(note: Note, context: Context) {
        tvNoteHeader.text = note.header
        note.todoes?.map { layoutTodoes.addView(TodoComponent(context)) }
    }
}