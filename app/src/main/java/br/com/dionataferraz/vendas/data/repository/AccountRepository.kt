package br.com.dionataferraz.vendas.data.repository

import br.com.dionataferraz.vendas.data.local.AccountModel
import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.data.remote.AccountDataSource
import java.util.*

class AccountRepository {

    private val remoteDataSource by lazy {
        AccountDataSource()
    }

    suspend fun inserir(accountBalance: Int, type: Type, date: String) {
        remoteDataSource.inserir(accountBalance = accountBalance, type = type, date = date)
    }

    suspend fun buscar(): List<AccountModel> {
        return remoteDataSource.buscar()
    }

}