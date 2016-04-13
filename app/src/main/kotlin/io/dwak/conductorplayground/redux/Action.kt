package io.dwak.conductorplayground.redux

data class Action<T : Enum<*>, V>(val action : T, val value : V? = null)
