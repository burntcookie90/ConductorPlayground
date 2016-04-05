package io.dwak.conductorplayground.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import io.dwak.conductorplayground.R
import io.dwak.conductorplayground.extension.bindView

class HomeController : Controller() {
  private val mainText : TextView by bindView(R.id.main_text)
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val rootView = inflater.inflate(R.layout.controller_home, container, false)
    return rootView
  }

  override fun onAttach(view: View) {
    super.onAttach(view)
    mainText.text = "Test text"
  }
}