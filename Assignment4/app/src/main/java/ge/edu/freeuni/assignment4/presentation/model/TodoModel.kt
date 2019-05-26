package ge.edu.freeuni.assignment4.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/*
* created by tgeldiashvili on 5/23/2019
*/
@Parcelize
data class TodoModel(
    val isDone: Boolean,
    val content: String,
    val id: Int
) : Parcelable