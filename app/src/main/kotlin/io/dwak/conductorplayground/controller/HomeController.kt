package io.dwak.conductorplayground.controller

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import butterknife.Bind
import butterknife.ButterKnife
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.rxlifecycle.RxController
import io.dwak.conductorplayground.R
import kotlin.properties.Delegates

class HomeController : RxController() {

  @Bind(R.id.main_text) lateinit var mainText: TextView
  @Bind(R.id.button) lateinit var button: Button

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val view = inflater.inflate(R.layout.controller_home, container, false)
    ButterKnife.bind(this, view)
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