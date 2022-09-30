package br.com.dionataferraz.vendas.data.remote

import android.util.Log
import br.com.dionataferraz.vendas.data.local.AccountEntity
import br.com.dionataferraz.vendas.data.local.AccountModel
import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.data.local.VendasDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun inserir(accountBalance: Int, type: Type, date: String) {
        return withContext(Dispatchers.IO) {
            database.DAO()
                .insertAccount(
                    AccountEntity(
                        accountBalance = accountBalance,
                        type = type,
                        date = date
                    )
                )

        }
    }

    suspend fun buscar(): List<AccountModel> {
        return withContext(Dispatchers.IO) {
            database.DAO()
                .getAccount().map {
                    AccountModel(
                        accountBalance = it.accountBalance,
                        type = it.type,
                        date = it.date
                    )
                }


        }
    }


}