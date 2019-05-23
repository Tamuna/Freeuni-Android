package ge.edu.freeuni.assignment4.ui.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.data.entity.NoteEntity
import ge.edu.freeuni.assignment4.ui.model.NoteModel


/*
* created by tgeldiashvili on 5/22/2019
*/

class RecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_HEADER: Int = 0
        private const val TYPE_NOTE: Int = 1
    }

    private var data: ArrayList<Any> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        return if (data[position] is NoteEntity)
            TYPE_NOTE
        else
            TYPE_HEADER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if (viewType == TYPE_NOTE) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.cell_note, parent, false)
            return NoteViewHolder(view)
        }
        view = LayoutInflater.from(parent.context).inflate(R.layout.cell_header, parent, false)
        return HeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = holder.itemViewType
        if (type == TYPE_NOTE) {
            (holder as NoteViewHolder).setData(data[position] as NoteModel, context)
        } else {
            (holder as HeaderViewHolder).setData(data[position] as String)
        }
    }

    fun setData(data: List<Any>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}