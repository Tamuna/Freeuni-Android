package ge.edu.freeuni.assignment4.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NoteModel(
    val id: Int,
    val isPinned: Boolean,
    val header: String,
    val todoes: List<TodoModel>
) : Parcelable
