package com.example.sistemacadastroalunosfutebol.models

import kotlin.math.roundToInt

data class Aluno(
    val nome: String,
    val massa: String,
    val altura: String,
    val isSubscribed: Boolean = false
) {
    val imc: Double
        get() {
            val arredondar = (((massa.toDouble()) / ((altura.toInt()) * (altura.toInt())) * 10000) * 100).roundToInt()
            return arredondar.toDouble() / 100
        }
}
