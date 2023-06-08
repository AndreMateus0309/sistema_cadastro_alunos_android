package com.example.sistemacadastroalunosfutebol.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sistemacadastroalunosfutebol.models.Aluno
import com.example.sistemacadastroalunosfutebol.viewModels.AlunosViewModel

@Composable
fun AlunosScreen(
    navController: NavController,
    alunosViewModel: AlunosViewModel
) {
    val uiState by alunosViewModel.alunosScreenUIState.collectAsState()

    AlunosList(
        alunos = uiState.allstudents,
        isSubscribed = {aluno, isSubscribed ->
            alunosViewModel.onAlunoSubscribedChange(
                aluno, isSubscribed
            )
        },
        onEditAluno = {alunosViewModel.EditAluno(it, navController)})
}


@Composable
fun AlunosList(
    alunos: List<Aluno>,
    isSubscribed: (Aluno, Boolean) -> Unit,
    onEditAluno: (Aluno) -> Unit
) {
    LazyColumn() {
        items(alunos) {aluno ->
            AlunosEntry(
                aluno = aluno,
                onCheckedChange = {
                    isSubscribed(aluno, it)
                },
                onEditAluno = {
                    onEditAluno(aluno)
                }
            )
        }
    }
}

@Composable
fun AlunosEntry(
    aluno: Aluno,
    onCheckedChange: (Boolean) -> Unit,
    onEditAluno: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                onEditAluno()
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = aluno.nome,
                fontSize = 20.sp
            )
            Text(
                text = "${aluno.imc}.",
                fontSize = 20.sp
            )
            Checkbox(
                checked = aluno.isSubscribed,
                onCheckedChange = onCheckedChange
            )
        }
    }
}