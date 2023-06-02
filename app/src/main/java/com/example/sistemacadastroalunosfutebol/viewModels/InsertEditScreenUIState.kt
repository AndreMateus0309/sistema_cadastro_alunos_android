package com.example.sistemacadastroalunosfutebol.viewModels

import kotlin.math.roundToInt

data class InsertEditScreenUIState(
    val nomeAluno: String = "",
    val isSubscribed: Boolean = false,
    val altura: String = "",
    val massa: String = "",

)
