package ge.edu.freeuni.assignment4.presentation.ui.editing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.presentation.model.TodoModel


/*
* created by tgeldiashvili on 5/23/2019
*/

class SingleNoteRecyclerAdapter(private val onItemClickListenerImpl: SingleNoteActivity.OnItemClickListenerImpl) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface OnItemClickListener {
        fun onAddItemClicked()
        fun onTodoChecked()
    }

    companion object {
        private const val TYPE_ADDITION: Int = 0
        private const val TYPE_DROP_DOWN: Int = 1
        private const val TYPE_TODO: Int = 2
    }

    private var data: ArrayList<Any> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        if (data[position] is TodoModel) {
            return TYPE_TODO
        }
        if (data[position] is Int) {
            return TYPE_DROP_DOWN
        }
        return TYPE_ADDITION
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_TODO -> (holder as TodoViewHolder).setData(data[position] as TodoModel, onItemClickListenerImpl)
            TYPE_ADDITION -> {
                (holder as AdditionViewHolder).setListener(onItemClickListenerImpl)
            }
            else -> (holder as DropDownViewHolder).setData(data[position] as Int)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return when (viewType) {
            TYPE_TODO -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.cell_todo, parent, false)
                TodoViewHolder(view)
            }
            TYPE_ADDITION -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.cell_plus_list_item, parent, false);
                AdditionViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.cell_drop_down, parent, false);
                DropDownViewHolder(view)
            }
        }
    }

    private fun modifyData(data: List<TodoModel>, checkNumber: Int): List<Any> {
        var result: ArrayList<Any> = ArrayList()
        result.addAll(data)

        var idx = data.indexOfFirst { it.isDone }
        if (idx >= 0) {
            result.add(idx, checkNumber)
            result.add(idx, "add next")
        } else {
            result.add("add next")
        }
        return result
    }

    fun setData(data: List<TodoModel>, checkNumber: Int) {
        this.data.clear()
        this.data.addAll(modifyData(data, checkNumber))
        notifyDataSetChanged()
    }

    fun getTodoes(): List<Any> {
        return data
    }
}