package br.com.dionataferraz.vendas.data.repository

import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.data.remote.AccountDataSource
import java.util.*

class AccountRepository {

    private val remoteDataSource by lazy {
        AccountDataSource()
    }

    suspend fun account(accountBalance: Int, type: Type, date: String) {
        return remoteDataSource.account(accountBalance = accountBalance, type = type, date = date)
    }

}