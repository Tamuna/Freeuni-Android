package ge.edu.freeuni.assignment4.ui.editing

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.ui.model.TodoModel
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.text.Spannable
import android.widget.TextView

/*
* created by tgeldiashvili on 5/23/2019
*/

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.cbTodo)
    lateinit var cbTodo: CheckBox

    @BindView(R.id.imgCross)
    lateinit var imgCross: ImageView

    init {
        ButterKnife.bind(this, itemView)
    }

    private fun strikeText(textContent: String) {
        cbTodo.setText(textContent, TextView.BufferType.SPANNABLE)
        val spannable = cbTodo.text as Spannable
        spannable.setSpan(StrikethroughSpan(), 0, textContent.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
    }

    fun setData(todoModel: TodoModel, isNowEditing: Boolean) {
        if (isNowEditing) {
            imgCross.visibility = View.GONE
        }
        if (todoModel.isDone) {
            strikeText(todoModel.content)
            cbTodo.isChecked = true
        } else {
            cbTodo.text = todoModel.content
        }
    }
}