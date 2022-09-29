package br.com.dionataferraz.vendas.data.remote

import android.util.Log
import br.com.dionataferraz.vendas.data.local.AccountEntity
import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.data.local.VendasDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class AccountDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun account(accountBalance: Int, type: Type, date: String) {
        return withContext(Dispatchers.IO) {
            database.DAO()
                .insertAccount(
                    AccountEntity(
                        accountBalance = accountBalance,
                        type = type,
                        date = date
                    )
                )

            val account = database.DAO().getAccount()
            Log.e("account ", account.toString())
        }
    }


}