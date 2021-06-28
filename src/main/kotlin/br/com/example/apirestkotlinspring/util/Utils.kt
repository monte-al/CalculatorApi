package br.com.example.apirestkotlinspring.util

import org.springframework.validation.BindingResult

class Utils {

    companion object {
        fun obterMensagens(bindingResult: BindingResult): ArrayList<String> {

            val mensagens = arrayListOf<String>()

            bindingResult.fieldErrors.forEach {
                it.defaultMessage?.let { l -> mensagens.add(l)}
            }

            return mensagens
        }
    }
}