package com.example.sistemacadastroalunosfutebol.views

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sistemacadastroalunosfutebol.viewModels.AlunosViewModel

@Composable
fun InserirEditarAlunoScreen(
    navController: NavController,
    alunosViewModel: AlunosViewModel
) {
    InsertEditForm(
        name = "",
        altura = "",
        massa = "",
        isSubscribed = false,
        onNameChange = {},
        onSubscribedChange = {},
        onAlturaChange = {},
        onMassaChange = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertEditForm(
    name: String,
    altura: String,
    massa: String,
    isSubscribed: Boolean,
    onNameChange: (String) -> Unit,
    onSubscribedChange: (Boolean) -> Unit,
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
            value = altura.toString(),
            onValueChange = onAlturaChange
        )
        OutlinedTextField(
            label = {
                Text(text = "Massa do Aluno")
            },
            value = massa.toString(),
            onValueChange = onMassaChange
        )
        Row(

        ) {
            Checkbox(
                checked = isSubscribed, onCheckedChange = onSubscribedChange
            )

        }
    }
}