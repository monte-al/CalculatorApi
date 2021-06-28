package br.com.example.apirestkotlinspring.validator

import br.com.example.apirestkotlinspring.wrappers.request.CalculadoraRequest
import org.springframework.stereotype.Service
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import java.math.BigDecimal

@Service
class CalculoValidator : Validator {

    override fun validate(target: Any, erros: Errors) {

        val bindingResult = BeanPropertyBindingResult(target, erros.objectName)
        val calculadoraRequest = target as CalculadoraRequest


        if (calculadoraRequest.numero1 < BigDecimal.ZERO) {
            erros.rejectValue("numero1", "Atributo numero1 nao pode ser negativo", "Atributo numero1 nao pode ser negativo")
        }

        if (calculadoraRequest.numero2 < BigDecimal.ZERO) {
            erros.rejectValue("numero2", "Atributo numero2 na pode ser negativo", "Atributo numero2 nao pode ser negativo")
        }

        if (calculadoraRequest.operacao.isEmpty()) {
            erros.rejectValue("operacao", "Atributo operacao nao pode ser vazio", "Atributo operacao nao pode ser vazio")
        }

        if (calculadoraRequest.operacao.matches(Regex("^[-+*/]?"))) {
            erros.rejectValue("Operacao", "Atributo operacao deve conter apenas operacoes aritmeticas", "Atributo operacao deve conter apenas operacoes aritmeticas")
        }

        erros.addAllErrors(bindingResult)
    }

    override fun supports(clazz: Class<*>): Boolean {
        return CalculadoraRequest::class.java.isAssignableFrom(clazz)
    }
}