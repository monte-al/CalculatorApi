package br.com.example.apirestkotlinspring.wrappers.request

import java.math.BigDecimal

data class CalculadoraRequest(
        val numero1: BigDecimal = BigDecimal.ZERO,
        val numero2: BigDecimal = BigDecimal.ZERO,
        val operacao: String
)