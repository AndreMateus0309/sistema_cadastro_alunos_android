package com.example.sistemacadastroalunosfutebol.viewModels

import com.example.sistemacadastroalunosfutebol.models.Aluno

data class AlunosScreenUIState(
    val allstudents: List<Aluno> = listOf(
        Aluno(nome = "André Mateus", massa = "70.0", altura = "180", isSubscribed = false),
        Aluno(nome = "João Lucas", massa = "48.0", altura = "175", isSubscribed = true),
        Aluno(nome = "Bruno Otávio", massa = "40.0", altura = "150", isSubscribed = false),
        Aluno(nome = "Pedro Vieira", massa = "45.0", altura = "145", isSubscribed = true)
    )
)
