package br.com.example.apirestkotlinspring.wrappers.response

data class ApiResponse(
        val statusCode: Int = 200,
        val mensagem: String = "Operacao realizada com sucesso",
        val mensagens: ArrayList<String> = arrayListOf(),
        val data: Any? = null
)