package com.example.sistemacadastroalunosfutebol.viewModels

import androidx.lifecycle.ViewModel
import com.example.sistemacadastroalunosfutebol.models.Aluno
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AlunosViewModel:ViewModel(

) {
    private var _mainScreenUIState: MutableStateFlow<MainScreenUIState> = MutableStateFlow(
        MainScreenUIState()
    )
    val mainScreenUIState: StateFlow<MainScreenUIState = _mainScreenUIState.asStateFlow()

    private var _alunosScreenUIState: MutableStateFlow<AlunosScreenUIState> = MutableStateFlow(
        AlunosScreenUIState()
    )
    val alunosScreenUIState: StateFlow<AlunosScreenUIState> = _alunosScreenUIState.asStateFlow()

    private var _insertEditScreenUIState: MutableStateFlow<InsertEditScreenUIState> = MutableStateFlow(
        InsertEditScreenUIState()
    )
    val insertEditScreenUIState: StateFlow<InsertEditScreenUIState> = _insertEditScreenUIState.asStateFlow()

    fun onAlunoNameChange(newAlunoName: String) {
        _insertEditScreenUIState.update { currentState ->
            currentState.copy(nomeAluno = newAlunoName)
        }
    }

    fun onAlunoSubscribedChange(updatedAluno: Aluno, newAlunoSubscribed: Boolean) {
        val allAlunosTemp = _alunosScreenUIState.value.allstudents.toMutableList()
        var pos = -1
        allAlunosTemp.forEachIndexed { index, aluno ->
            if(updatedAluno == aluno) {
                pos = index
            }
        }
        allAlunosTemp.removeAt(pos)
        allAlunosTemp.add(pos, updatedAluno.copy(isSubscribed = newAlunoSubscribed))
        _insertEditScreenUIState.update { currentState ->
            currentState.copy(isSubscribed = newAlunoSubscribed)
        }
    }

    fun onAlunoAlturaChange(newAlunoAltura: String) {
        _insertEditScreenUIState.update { currentState ->
            currentState.copy(altura = newAlunoAltura)
        }
    }
}