package io.dwak.conductorplayground.controller

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import butterknife.Bind
import io.dwak.conductorplayground.R
import io.dwak.conductorplayground.extension.pushController
import io.dwak.conductorplayground.redux.Action
import io.dwak.conductorplayground.redux.Dispatcher
import javax.inject.Inject

class HomeController() : BaseController(R.layout.controller_home) {

  @field:Inject lateinit var dispatcher : Dispatcher

  @Bind(R.id.recycler) lateinit var recyclerView : RecyclerView
  @Bind(R.id.button) lateinit var button : Button

  enum class HomeActions { ADD, SELECT, DELETE }

  override fun onCreateView(inflater : LayoutInflater, container : ViewGroup) : View {
    objectGraph.inject(this)
    return super.onCreateView(inflater, container)
  }

  override fun onAttach(view : View) {
    super.onAttach(view)
    button.setOnClickListener { dispatcher.dispatch(Action<HomeActions, Any?>(HomeActions.ADD))}
  }
}