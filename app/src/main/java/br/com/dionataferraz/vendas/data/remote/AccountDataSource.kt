package br.com.dionataferraz.vendas.data.remote

import android.util.Log
import br.com.dionataferraz.vendas.App
import br.com.dionataferraz.vendas.data.local.AccountEntity
import br.com.dionataferraz.vendas.data.local.VendasDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance(App.context)
    }

    suspend fun account(accountBalance: Int) {
        return withContext(Dispatchers.IO) {
            database.DAO()
                .insertAccount(AccountEntity(accountBalance = accountBalance))

            val account = database.DAO().getAccount()
            Log.e("account ", account.toString())
        }
    }


}