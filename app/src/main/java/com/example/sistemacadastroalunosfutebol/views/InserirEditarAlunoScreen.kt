package com.example.sistemacadastroalunosfutebol.views

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sistemacadastroalunosfutebol.models.Aluno
import com.example.sistemacadastroalunosfutebol.viewModels.AlunosViewModel

@Composable
fun InserirEditarAlunoScreen(
    navController: NavController,
    alunosViewModel: AlunosViewModel
) {
    val uiState by alunosViewModel.insertEditScreenUIState.collectAsState()
    BackHandler {
        alunosViewModel.onBackPressed(navController)
    }
    InsertEditForm(
        name = uiState.nomeAluno,
        altura = uiState.altura,
        massa = uiState.massa,
        onNameChange = {
            alunosViewModel.onAlunoNameChange(
                it
            )
        },
        onAlturaChange = {
            alunosViewModel.onAlunoAlturaChange(
                it
            )
        },
        onMassaChange = {
            alunosViewModel.onAlunoMassaChange(
                it
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertEditForm(
    name: String,
    altura: String,
    massa: String,
    onNameChange: (String) -> Unit,
    onAlturaChange: (String) -> Unit,
    onMassaChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        OutlinedTextField(
            label = {
                Text(text = "Nome do Aluno")
            },
            value = name,
            onValueChange = onNameChange
        )
        Spacer(
            modifier = Modifier.height(
                3.dp
            )
        )
        OutlinedTextField(
            label = {
                Text(text = "Altura do Aluno")
            },
            value = altura,
            onValueChange = onAlturaChange
        )
        OutlinedTextField(
            label = {
                Text(text = "Massa do Aluno")
            },
            value = massa,
            onValueChange = onMassaChange
        )

    }
}