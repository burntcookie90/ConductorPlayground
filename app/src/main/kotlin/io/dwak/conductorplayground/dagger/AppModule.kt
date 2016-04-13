package io.dwak.conductorplayground.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import io.dwak.conductorplayground.redux.AppDispatcher
import io.dwak.conductorplayground.redux.Dispatcher
import javax.inject.Singleton

@Module(library = true)
class AppModule(val context : Context) {
  @Provides fun context() = context

  @Provides @Singleton fun dispatcher() :  Dispatcher = AppDispatcher
}