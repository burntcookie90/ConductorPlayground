package io.dwak.conductorplayground.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.bluelinelabs.conductor.rxlifecycle.RxController

abstract class BaseController(val layoutResId : Int) : RxController() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(layoutResId, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        ButterKnife.unbind(this)
    }
}