package io.dwak.conductorplayground.extension

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler

fun Controller.pushController(controller: Controller)
        = router.pushController(RouterTransaction.builder(controller)
        .popChangeHandler(FadeChangeHandler())
        .pushChangeHandler(FadeChangeHandler())
        .build())

