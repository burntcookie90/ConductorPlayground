package io.dwak.conductorplayground.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import io.dwak.conductorplayground.model.Note
import io.dwak.conductorplayground.model.NoteModel
import javax.inject.Inject
import kotlin.properties.Delegates

val DATABASE_VERSION = 1
class NoteOpenHelper @Inject constructor(context : Context) : SQLiteOpenHelper(context, null, null, DATABASE_VERSION) {
  companion object {
    var instance : NoteOpenHelper? = null

    fun getInstance(context : Context) : NoteOpenHelper {
      if(instance == null){
        instance = NoteOpenHelper(context)
      }

      return instance!!
    }
  }

  override fun onCreate(db : SQLiteDatabase) {
    db.execSQL(NoteModel.CREATE_TABLE)
  }

  override fun onUpgrade(db : SQLiteDatabase?, oldVersion : Int, newVersion : Int) {
  }
}