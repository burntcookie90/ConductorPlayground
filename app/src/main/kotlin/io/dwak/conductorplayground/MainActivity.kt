package io.dwak.conductorplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import io.dwak.conductorplayground.controller.HomeController
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

  private var router : Router by Delegates.notNull()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    router = Conductor.attachRouter(this, container, savedInstanceState).apply {
      if(!hasRootController()){
        setRoot(HomeController())
      }
    }
  }

  override fun onBackPressed() {
    if(!router.handleBack()) super.onBackPressed()
  }
}
