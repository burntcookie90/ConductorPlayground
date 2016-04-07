package io.dwak.conductorplayground.controller

import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.Bind
import io.dwak.conductorplayground.R
import io.dwak.conductorplayground.extension.pushController

class HomeController() : BaseController(R.layout.controller_home) {

  @Bind(R.id.main_text) lateinit var mainText: TextView
  @Bind(R.id.button) lateinit var button: Button

  override fun onAttach(view: View) {
    super.onAttach(view)
    mainText.text = "Test text"

    button.setOnClickListener { pushController(SecondController()) }
  }
}