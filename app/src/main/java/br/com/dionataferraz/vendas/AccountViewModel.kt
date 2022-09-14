package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val account: MutableLiveData<AccountActivity.Account> = MutableLiveData()
    val accountLiveData: LiveData<AccountActivity.Account> = account

    fun createAccount(
        nameAccount: String,
        accountBalance: String,
        nameUser: String,
        accountRB: String
    ) {
        val accountCreated = AccountActivity.Account(
            nameAccount = nameAccount,
            accountBalance = accountBalance,
            nameUser = nameUser,
            accountRB = accountRB
        )
        account.value = accountCreated
    }
}