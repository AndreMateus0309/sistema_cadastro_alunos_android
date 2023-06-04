package com.example.sistemacadastroalunosfutebol.viewModels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.sistemacadastroalunosfutebol.R
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
    val mainScreenUIState: StateFlow<MainScreenUIState> = _mainScreenUIState.asStateFlow()

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
            currentState.copy()
        }
    }

    fun onAlunoAlturaChange(newAlunoAltura: String) {
        _insertEditScreenUIState.update { currentState ->
            currentState.copy(altura = newAlunoAltura)
        }
    }

    fun onAlunoMassaChange(newAlunoMassa: String) {
        _insertEditScreenUIState.update { currentState ->
            currentState.copy(massa = newAlunoMassa)
        }
    }

    var editAluno: Boolean = false
    var alunoToEdit: Aluno = Aluno("", "", "", false)

    fun navigate(navController: NavController) {
        if(_mainScreenUIState.value.screenName == "AlunosList") {
            if(editAluno) {
                _mainScreenUIState.update { currentState ->
                    currentState.copy(
                        screenName = "UpdateAluno",
                        fabIcon = R.drawable.baseline_check_24
                    )
                }
            } else {
                _mainScreenUIState.update { currentState ->
                    currentState.copy(
                        screenName = "InserirAluno",
                        fabIcon = R.drawable.baseline_check_24
                    )
                }
            }
            navController.navigate("InserirEditarAluno")
        } else {
            _mainScreenUIState.update { currentState ->
                currentState.copy(
                    screenName = "AlunosList",
                    fabIcon = R.drawable.baseline_add_24
                )
            }
            if(editAluno) {
                val allAlunosTemp = _alunosScreenUIState.value.allstudents.toMutableList()
                var pos = -1
                allAlunosTemp.forEachIndexed { index, aluno ->
                    if(alunoToEdit == aluno) {
                        pos = index
                    }
                }
                allAlunosTemp.removeAt(pos)
                allAlunosTemp.add(pos, alunoToEdit.copy(
                    nome = _insertEditScreenUIState.value.nomeAluno,
                    massa = _insertEditScreenUIState.value.massa,
                    altura = _insertEditScreenUIState.value.altura,
                    isSubscribed = _insertEditScreenUIState.value.isSubscribed
                ))
                _insertEditScreenUIState.update { currentState ->
                    currentState.copy()
                }
            } else {
                _alunosScreenUIState.update { currentState ->
                    currentState.copy(
                        allstudents = currentState.allstudents + Aluno(
                            nome = _insertEditScreenUIState.value.nomeAluno,
                            massa = _insertEditScreenUIState.value.massa,
                            altura = _insertEditScreenUIState.value.altura,
                            isSubscribed = _insertEditScreenUIState.value.isSubscribed,
                        )
                    )
                }
            }
            navController.navigate("AlunosList")
        }
    }
}