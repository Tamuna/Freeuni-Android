package ge.edu.freeuni.assignment4.ui.editing

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/*
* created by tgeldiashvili on 5/23/2019
*/

class SingleNoteRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ADDITION: Int = 0
        private const val TYPE_DROP_DOWN: Int = 1
        private const val TYPE_TODO: Int = 2
        private const val TYPE_DIVIDER: Int = 4
    }

    private var data: ArrayList<Any> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setData(data: List<Any>) {

    }
}