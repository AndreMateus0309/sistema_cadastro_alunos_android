package com.example.sistemacadastroalunosfutebol.models

import kotlin.math.roundToInt

data class Aluno(
    val nome: String,
    val massa: Double,
    val altura: Int,
    val isSubscribed: Boolean = false
) {
    val imc: Double
        get() {
            val arredondar = (((massa) / ((altura) * (altura)) * 10000) * 100).roundToInt()
            return arredondar.toDouble() / 100
        }
}
