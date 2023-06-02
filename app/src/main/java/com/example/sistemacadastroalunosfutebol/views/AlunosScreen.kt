package com.example.sistemacadastroalunosfutebol.views

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
    AlunosList(alunos = listOf(
        Aluno(nome = "André Mateus", massa = 70.0, altura = 180, isSubscribed = false),
        Aluno(nome = "João Lucas", massa = 48.0, altura = 175, isSubscribed = true),
        Aluno(nome = "Bruno Otávio", massa = 40.0, altura = 150, isSubscribed = false),
        Aluno(nome = "Pedro Vieira", massa = 45.0, altura = 145, isSubscribed = true)
    ))
}

@Composable
fun AlunosList(
    alunos: List<Aluno>
) {
    LazyColumn() {
        items(alunos) {aluno ->
            AlunosEntry(
                aluno = aluno,
                onCheckedChange = {

                })
        }
    }
}

@Composable
fun AlunosEntry(
    aluno: Aluno,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
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