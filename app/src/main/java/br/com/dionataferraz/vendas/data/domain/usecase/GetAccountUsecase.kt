package br.com.dionataferraz.vendas.data.domain.usecase

import br.com.dionataferraz.vendas.data.local.AccountModel
import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.data.repository.AccountRepository

class GetAccountUsecase {

    private val repository by lazy {
        AccountRepository()
    }

    suspend fun inserir(accountBalance: Double, type: Type, date: String) {
        repository.inserir(accountBalance = accountBalance, type = type, date = date)
    }

    suspend fun buscar(): List<AccountModel> {
        return repository.buscar()
    }

    suspend fun findBalance(): Double {
        return repository.findBalance()
    }
}