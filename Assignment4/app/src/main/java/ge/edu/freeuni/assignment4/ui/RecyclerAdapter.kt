package ge.edu.freeuni.assignment4.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.edu.freeuni.assignment4.R
import ge.edu.freeuni.assignment4.data.entity.Note


/*
* created by tgeldiashvili on 5/22/2019
*/

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val TYPE_HEADER: Int = 0
        private const val TYPE_NOTE: Int = 1
    }

    private var data: ArrayList<Any> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        return if (data[position] is Note)
            TYPE_NOTE
        else
            TYPE_HEADER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if (viewType == TYPE_NOTE) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.cell_note, parent, false)
            return NoteViewHolder(parent)
        }
        view = LayoutInflater.from(parent.context).inflate(R.layout.cell_header, parent, false)
        return HeaderViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setData(data: List<Any>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

}