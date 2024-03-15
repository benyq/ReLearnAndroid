package com.benyq.relearnandroid.feature.mvi.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benyq.relearnandroid.feature.mvi.ContainerLazy
import com.benyq.relearnandroid.feature.mvi.MutableContainer
import com.benyq.relearnandroid.feature.mvi.UiEvent
import com.benyq.relearnandroid.feature.mvi.UiState

/**
 * 构建viewModel的Ui容器，存储Ui状态和一次性事件
 */
fun <STATE : UiState, SINGLE_EVENT : UiEvent> ViewModel.containers(
    initialState: STATE,
): Lazy<MutableContainer<STATE, SINGLE_EVENT>> {
    return ContainerLazy(initialState, viewModelScope)
}