package zisis.aristofanis.animehouse.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import zisis.aristofanis.animehouse.presentation.state_management.State
import zisis.aristofanis.animehouse.presentation.state_management.UserAction

@ExperimentalCoroutinesApi
abstract class BaseViewModel<S : State, I : UserAction> constructor(
    private val initialState: S,
    private val intentAction: I
) :
    ViewModel() {

    private val mutableStateFlow: MutableStateFlow<S> = MutableStateFlow(initialState)

    init {
        onIntentAction(intentAction)
    }

    suspend fun setState(reduce: suspend StateFlow<S>.() -> Flow<S>) {
        currentStateFlow.reduce().collect { mutableStateFlow.value = it }
    }

    fun state(): StateFlow<S> = mutableStateFlow

    fun onIntentAction(action: I) = viewModelScope.launch {
        handleIntentAction(action)
    }

    abstract suspend fun handleIntentAction(intentAction: I)

    private val currentStateFlow: StateFlow<S>
        get() = mutableStateFlow

}
