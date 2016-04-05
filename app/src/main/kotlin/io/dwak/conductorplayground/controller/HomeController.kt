package io.dwak.conductorplayground.controller

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.rxlifecycle.RxController
import io.dwak.conductorplayground.R
import kotlin.properties.Delegates

class HomeController : RxController() {

  init {
    lifecycle().subscribe { Log.d("TAG", it.name) }
  }
  private var mainText: TextView by Delegates.notNull()
  private var button: Button by Delegates.notNull()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val view = inflater.inflate(R.layout.controller_home, container, false)
    mainText = view.findViewById(R.id.main_text) as TextView
    button = view.findViewById(R.id.button) as Button
    return view
  }

  override fun onAttach(view: View) {
    super.onAttach(view)
    mainText.text = "Test text"

    button.setOnClickListener {
      router.pushController(RouterTransaction.builder(SecondController())
              .pushChangeHandler(FadeChangeHandler())
              .popChangeHandler(FadeChangeHandler())
              .build())
    }
  }
}