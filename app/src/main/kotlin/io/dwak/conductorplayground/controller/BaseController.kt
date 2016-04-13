package io.dwak.conductorplayground.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.bluelinelabs.conductor.rxlifecycle.RxController
import dagger.ObjectGraph
import io.dwak.conductorplayground.MainActivity
import io.dwak.conductorplayground.dagger.AppModule

abstract class BaseController(val layoutResId : Int) : RxController() {

  protected val objectGraph : ObjectGraph by lazy { ObjectGraph.create(AppModule(applicationContext)) }

  override fun onCreateView(inflater : LayoutInflater, container : ViewGroup) : View {
    val view = inflater.inflate(layoutResId, container, false)
    ButterKnife.bind(this, view)
    return view
  }

  override fun onDetach(view : View) {
    super.onDetach(view)
    ButterKnife.unbind(this)
  }
}