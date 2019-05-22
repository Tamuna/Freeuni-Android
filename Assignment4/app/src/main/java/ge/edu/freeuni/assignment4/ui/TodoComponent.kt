package ge.edu.freeuni.assignment4.ui

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

    private val unbinder: Unbinder

    init {
        View.inflate(context, R.layout.component_todo, this)
        unbinder = ButterKnife.bind(this)
    }

    fun setTodo(todo: String) {
        tvSingleTodo.text = todo
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        unbinder.unbind()
    }
}