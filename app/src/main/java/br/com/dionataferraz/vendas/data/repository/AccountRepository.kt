package br.com.dionataferraz.vendas.data.repository

import br.com.dionataferraz.vendas.data.local.AccountModel
import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.data.local.LocalDataSource

class AccountRepository {

    private val remoteDataSource by lazy {
        LocalDataSource()
    }

    suspend fun inserir(accountBalance: Double, type: Type, date: String) {
        remoteDataSource.inserir(accountBalance = accountBalance, type = type, date = date)
    }

    suspend fun buscar(): List<AccountModel> {
        return remoteDataSource.buscar()
    }

    suspend fun findBalance(): Double {
        return remoteDataSource.findBalance()
    }


}