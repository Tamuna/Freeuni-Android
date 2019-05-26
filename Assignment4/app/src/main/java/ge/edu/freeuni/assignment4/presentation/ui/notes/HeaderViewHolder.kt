package ge.edu.freeuni.assignment4.presentation.ui.notes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import ge.edu.freeuni.assignment4.R


/*
* created by tgeldiashvili on 5/22/2019
*/

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.tvHeaded)
    lateinit var tvHeader: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun setData(header: String) {
        tvHeader.text = header
    }
}