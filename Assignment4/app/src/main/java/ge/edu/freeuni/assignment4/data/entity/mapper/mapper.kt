package ge.edu.freeuni.assignment4.data.entity.mapper

import ge.edu.freeuni.assignment4.data.entity.NoteAndAllTodoes
import ge.edu.freeuni.assignment4.data.entity.NoteEntity
import ge.edu.freeuni.assignment4.data.entity.TodoEntity
import ge.edu.freeuni.assignment4.presentation.model.NoteModel
import ge.edu.freeuni.assignment4.presentation.model.TodoModel


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
    return TodoModel(isDone, content, id!!)
}

fun NoteAndAllTodoes.toModel(): NoteModel {
    var isPinned = false
    var header = ""
    var todoes: List<TodoModel> = ArrayList()
    note.isPinned?.let {
        isPinned = it
    }
    note.header?.let {
        header = it
    }
    this.todoes?.let { it1 ->
        todoes = it1.map { it.toModel() }
    }

    return NoteModel(isPinned, header, todoes.count { it.isDone }, todoes, note.id!!)
}

fun TodoModel.toEntity(): TodoEntity {
    var entity = TodoEntity(isDone, content)
    if (id >= 0) {
        entity.id = id
    }
    return entity
}

fun NoteModel.toEntity(): NoteAndAllTodoes {
    var entity = NoteAndAllTodoes(NoteEntity(isPinned, header), todoes.map { it.toEntity() })
    if (id >= 0) {
        entity.note.id = id

    }
    return entity
}



