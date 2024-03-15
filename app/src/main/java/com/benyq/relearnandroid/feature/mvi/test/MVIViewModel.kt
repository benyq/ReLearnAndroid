package com.benyq.relearnandroid.feature.mvi.test

import androidx.lifecycle.ViewModel
import com.benyq.relearnandroid.feature.mvi.extension.containers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

/**
 *
 * @author benyq
 * @date 12/7/2023
 *
 */
class MVIViewModel : ViewModel() {

    private val container by containers<MVIState, MVIEvent>(MVIState())

    val uiStateFlow: StateFlow<MVIState> = container.uiStateFlow
    val singleEventFlow: Flow<MVIEvent> = container.singleEventFlow

    fun change(name: String, age: Int) {
        updateState {
            copy(
                name = name, age = age
            )
        }
        sendEvent(MVIEvent.NameChangedToastEvent(name))
    }

    private fun updateState(action: MVIState.() -> MVIState) {
        container.updateState(action)
    }

    private fun sendEvent(event: MVIEvent) {
        container.sendEvent(event)
    }

}