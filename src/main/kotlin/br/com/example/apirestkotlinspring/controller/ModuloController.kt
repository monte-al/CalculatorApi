package br.com.example.apirestkotlinspring.controller

import br.com.example.apirestkotlinspring.service.CalculadoraService
import br.com.example.apirestkotlinspring.util.Utils
import br.com.example.apirestkotlinspring.validator.CalculoValidator
import br.com.example.apirestkotlinspring.wrappers.request.CalculadoraRequest
import br.com.example.apirestkotlinspring.wrappers.response.ApiResponse
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("calculadora")
class ModuloController(
        private val calculadoraService: CalculadoraService,
        private val calculoValidator: CalculoValidator
) {

    @PostMapping
    fun calculadora(
            @RequestBody calculadoraRequest: CalculadoraRequest,
            bindingResult: BindingResult
    ): ApiResponse {

        calculoValidator.validate(calculadoraRequest, bindingResult)

        return if (!bindingResult.hasErrors()) {
            val resultado = calculadoraService.realizarCalculo(calculadoraRequest)
            ApiResponse(data = resultado)
        } else {
            ApiResponse(statusCode = 500, mensagem = "", mensagens = Utils.obterMensagens(bindingResult))
        }
    }
}