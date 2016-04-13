package io.dwak.conductorplayground.redux

object AppDispatcher : Dispatcher{
  override fun <T : Enum<*>, V> dispatch(action : Action<T, V>) {
    throw UnsupportedOperationException()
  }
}