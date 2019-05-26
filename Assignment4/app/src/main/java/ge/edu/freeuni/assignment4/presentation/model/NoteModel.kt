package ge.edu.freeuni.assignment4.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NoteModel(
    var isPinned: Boolean,
    var header: String,
    var checkedNumber: Int,
    var todoes: List<TodoModel>,
    var id: Int
) : Parcelable
