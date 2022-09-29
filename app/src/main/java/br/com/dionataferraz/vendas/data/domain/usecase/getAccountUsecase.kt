package br.com.dionataferraz.vendas.data.domain.usecase

import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.data.repository.AccountRepository
import java.util.*

class getAccountUsecase {
    private val repository by lazy {
        AccountRepository()
    }

    suspend fun account(accountBalance: Int, type: Type, date: String) {
        return repository.account(accountBalance = accountBalance, type = type, date = date)
    }
}