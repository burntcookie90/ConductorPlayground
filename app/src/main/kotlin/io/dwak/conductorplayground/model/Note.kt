package io.dwak.conductorplayground.model

import com.google.auto.value.AutoValue

@AutoValue abstract class Note : NoteModel {
  companion object {
    class Marshal(note : Note) : NoteModel.NoteMarshal<Marshal>(note)

    val MAPPER : NoteModel.Mapper<Note> by lazy {
      NoteModel.Mapper<Note>(NoteModel.Mapper.Creator<Note> {
        _id, name, content, creation_date ->
        AutoValue_Note(_id, name, content, creation_date)
      })
    }

  }
}
