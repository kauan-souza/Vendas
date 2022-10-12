package br.com.dionataferraz.vendas.account.data.local

import android.util.Log
import br.com.dionataferraz.vendas.VendasDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun inserir(accountBalance: Double, type: Type, date: String) {
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

    suspend fun findBalance(): Double {
        return withContext(Dispatchers.IO) {
            val aaa = database.DAO().findBalance()
            Log.e("dataSource ", aaa.toString())
            aaa
        }
    }


}

