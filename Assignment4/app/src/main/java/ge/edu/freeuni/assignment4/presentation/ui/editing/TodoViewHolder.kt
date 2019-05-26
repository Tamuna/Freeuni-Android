package ge.edu.freeuni.assignment4.presentation.ui.editing

import android.text.Spannable
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.presentation.model.TodoModel

/*
* created by tgeldiashvili on 5/23/2019
*/

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.cbTodo)
    lateinit var cbTodo: CheckBox

    @BindView(R.id.imgCross)
    lateinit var imgCross: ImageView

    @BindView(R.id.etTodoContent)
    lateinit var etTodoContent: EditText

    init {
        ButterKnife.bind(this, itemView)
    }

    private fun strikeText(textContent: String) {
        etTodoContent.setText(textContent, TextView.BufferType.SPANNABLE)
        val spannable = etTodoContent.text as Spannable
        spannable.setSpan(StrikethroughSpan(), 0, textContent.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    }

    fun setData(todoModel: TodoModel, onItemClickListener: SingleNoteRecyclerAdapter.OnItemClickListener) {
        if (todoModel.isDone) {
            strikeText(todoModel.content)
            cbTodo.isChecked = true
            etTodoContent.alpha = 0.5f
        } else {
            etTodoContent.alpha = 1f
            cbTodo.isChecked = false
            etTodoContent.setText(todoModel.content)
        }
        cbTodo.setOnClickListener { onItemClickListener.onTodoChecked() }
    }
}