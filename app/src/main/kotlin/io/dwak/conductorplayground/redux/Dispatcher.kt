package io.dwak.conductorplayground.redux

interface Dispatcher {
  fun <T : Enum<*>, V> dispatch(action : Action<T, V>)
}