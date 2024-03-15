package com.benyq.relearnandroid.feature.mvi.test

import com.benyq.relearnandroid.feature.mvi.UiEvent
import com.benyq.relearnandroid.feature.mvi.UiState

/**
 *
 * @author benyq
 * @date 12/7/2023
 *
 */
data class MVIState(
    val name: String = "",
    val age: Int = 0,
): UiState

sealed class MVIEvent: UiEvent {
    data class NameChangedToastEvent(val name: String): MVIEvent()
}