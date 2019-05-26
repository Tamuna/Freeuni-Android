package ge.edu.freeuni.assignment4.presentation.ui.editing

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import ge.edu.freeuni.assignment4.R

class DropDownViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.imgDropDown)
    lateinit var imgDropDown: ImageView

    @BindView(R.id.txtNumTicked)
    lateinit var txtNumTicked: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun setData(numTicked: Int) {
        txtNumTicked.text = "+ $numTicked Ticked Items"
    }
}