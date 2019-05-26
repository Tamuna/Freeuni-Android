package ge.edu.freeuni.assignment4.presentation.ui.editing

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AdditionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setListener(onAddItemClickedListenerImpl: SingleNoteActivity.OnItemClickListenerImpl) {
        itemView.setOnClickListener { onAddItemClickedListenerImpl.onAddItemClicked() }
    }
}