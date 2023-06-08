@file:OptIn(ExperimentalMaterial3Api::class)
@file:Suppress("UNUSED_LAMBDA_EXPRESSION")

package com.example.sistemacadastroalunosfutebol.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sistemacadastroalunosfutebol.R
import com.example.sistemacadastroalunosfutebol.viewModels.AlunosViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainHomeScreen(
    alunosViewModel: AlunosViewModel = viewModel()
) {
    val navController = rememberNavController()
    val uiState by alunosViewModel.mainScreenUIState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Blue
                    ),
                title = {
                    Text(
                        color = Color.Black,
                        text = stringResource(
                            id = R.string.app_name
                        )
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    alunosViewModel.navigate(navController)
                }
            ) {
                Icon(
                    painter = painterResource(
                        id = uiState.fabIcon
                    ), contentDescription = "FABIcon"
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "AlunosList"
        ) {
            composable("AlunosList") {
                AlunosScreen(
                    navController = navController,
                    alunosViewModel = alunosViewModel
                )
            }
            composable("InserirEditarAluno") {
                InserirEditarAlunoScreen(
                    navController = navController,
                    alunosViewModel = alunosViewModel
                )
            }
        }
    }
}