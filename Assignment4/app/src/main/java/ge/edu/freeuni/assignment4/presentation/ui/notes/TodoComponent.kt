package ge.edu.freeuni.assignment4.presentation.ui.notes

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import ge.edu.freeuni.assignment4.R


/*
* created by tgeldiashvili on 5/22/2019
*/

class TodoComponent @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {
    @BindView(R.id.tvSingleTodo)
    lateinit var tvSingleTodo: TextView


    init {
        View.inflate(context, R.layout.component_todo, this)
        ButterKnife.bind(this)
    }

    fun setTodo(todo: String) {
        tvSingleTodo.text = todo
    }
}