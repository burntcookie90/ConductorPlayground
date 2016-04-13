package io.dwak.conductorplayground.db

import com.squareup.sqlbrite.SqlBrite
import io.dwak.conductorplayground.model.Note
import io.dwak.conductorplayground.model.NoteModel
import rx.Observable
import rx.Scheduler
import javax.inject.Inject

class NoteData @Inject constructor(private val sqlLiteOpenHelper : NoteOpenHelper,
                                   private val sqlBrite : SqlBrite,
                                   private val scheduler : Scheduler) {
  private val db = sqlBrite.wrapDatabaseHelper(sqlLiteOpenHelper, scheduler)

  fun notes() = db.createQuery(NoteModel.TABLE_NAME, NoteModel.SELECT_ALL)
          .map { it.run() }
          .map { Note.MAPPER.map(it) }

  fun add(note : Note) = db.insert(NoteModel.TABLE_NAME,
                                   Note.Companion.Marshal(note).asContentValues())

  fun remove(note : Note) = db.delete(NoteModel.TABLE_NAME, NoteModel.SELECT_BY_ID,
                                      note._id().toString())

  fun update(note : Note) = db.update(NoteModel.TABLE_NAME,
                                      Note.Companion.Marshal(note).asContentValues(),
                                      NoteModel.SELECT_BY_ID,
                                      note._id().toString())
}