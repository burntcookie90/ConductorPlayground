package io.dwak.conductorplayground.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import io.dwak.conductorplayground.R

class SecondController : Controller() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup)
          = inflater.inflate(R.layout.controller_second, container, false)

}
