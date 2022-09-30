package br.com.dionataferraz.vendas.data.local

data class AccountModel(
    val accountBalance: Int,
    val type: Type,
    val date: String
)

enum class Type(val action: String) {
    SAQUE("retirada"),
    DEPOSITO("inserir")
}