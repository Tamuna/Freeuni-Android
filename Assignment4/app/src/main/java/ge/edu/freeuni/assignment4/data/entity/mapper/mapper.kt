package ge.edu.freeuni.assignment4.data.entity.mapper

import ge.edu.freeuni.assignment4.ui.model.NoteModel
import ge.edu.freeuni.assignment4.ui.model.TodoModel
import ge.edu.freeuni.assignment4.data.entity.NoteEntity
import ge.edu.freeuni.assignment4.data.entity.TodoEntity


/*
* created by tgeldiashvili on 5/23/2019
*/

fun TodoEntity.toModel(): TodoModel {
    var isDone = false
    var content = ""
    this.isDone?.let {
        isDone = it
    }
    this.content?.let {
        content = it
    }
    return TodoModel(id, noteId, isDone, content)
}

fun NoteEntity.toModel(): NoteModel? {
    var isPinned = false
    var header = ""
    var todoes: List<TodoEntity> = ArrayList()
    this.isPinned?.let {
        isPinned = it
    }
    this.header?.let {
        header = it
    }
    this.todoes?.let {
        todoes = it
    }
    return NoteModel(id, isPinned, header, todoes.map { it.toModel() })
}


fun TodoModel.toEntity(): TodoEntity {
    return TodoEntity(id, noteId, isDone, content)
}

fun NoteModel.toEntity(): NoteEntity {
    return NoteEntity(id, isPinned, header, todoes.map { it.toEntity() })
}



