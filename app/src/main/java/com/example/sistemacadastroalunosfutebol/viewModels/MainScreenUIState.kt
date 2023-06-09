package com.example.sistemacadastroalunosfutebol.viewModels

import androidx.annotation.DrawableRes
import com.example.sistemacadastroalunosfutebol.R

data class MainScreenUIState(
    val screenName: String = "AlunosList",
    @DrawableRes val fabIcon: Int = R.drawable.baseline_add_24
)
