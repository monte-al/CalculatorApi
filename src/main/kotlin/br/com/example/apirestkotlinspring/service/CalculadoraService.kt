package br.com.example.apirestkotlinspring.service

import br.com.example.apirestkotlinspring.wrappers.request.CalculadoraRequest
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CalculadoraService {

    fun realizarCalculo(calculadoraRequest: CalculadoraRequest): BigDecimal {
        return when (calculadoraRequest.operacao) {
            "+" -> calculadoraRequest.numero1.add(calculadoraRequest.numero2)
            "-" -> calculadoraRequest.numero1.subtract(calculadoraRequest.numero2)
            "*" -> calculadoraRequest.numero1.multiply(calculadoraRequest.numero2)
            "/" -> calculadoraRequest.numero1.divide(calculadoraRequest.numero2)
            else -> BigDecimal.ZERO
        }
    }
}