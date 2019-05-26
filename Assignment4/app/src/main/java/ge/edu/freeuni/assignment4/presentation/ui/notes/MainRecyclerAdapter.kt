package ge.edu.freeuni.assignment4.presentation.ui.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.presentation.model.NoteModel


/*
* created by tgeldiashvili on 5/22/2019
*/

class MainRecyclerAdapter(
    private val context: Context,
    private val onItemClickedListenerImpl: MainActivity.OnItemClickedListenerImpl
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_HEADER: Int = 0
        private const val TYPE_NOTE: Int = 1
    }

    interface OnItemClickedListener {
        fun onNoteItemClicked(noteModel: NoteModel)
    }

    private var data: ArrayList<Any> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        return if (data[position] is NoteModel)
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
            (holder as NoteViewHolder).setData(onItemClickedListenerImpl, data[position] as NoteModel, context)
        } else {
            (holder as HeaderViewHolder).setData(data[position] as String)
            val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
            layoutParams.isFullSpan = true
        }
    }

    private fun transformData(data: List<NoteModel>): List<Any> {
        val result: ArrayList<Any> = ArrayList()
        var pinnedAdded = false
        var otherAdded = false
        data.map {
            if (it.isPinned && !pinnedAdded) {
                result.add(context.getString(R.string.pinned))
                pinnedAdded = true
            } else if (!it.isPinned && pinnedAdded && !otherAdded) {
                result.add(context.getString(R.string.other))
                otherAdded = true
            }
            result.add(it)
        }
        return result
    }

    fun setData(data: List<NoteModel>) {
        this.data.clear()
        this.data.addAll(transformData(data))
        notifyDataSetChanged()
    }
}