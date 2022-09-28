package br.com.dionataferraz.vendas


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.data.domain.usecase.getAccountUsecase
import br.com.dionataferraz.vendas.data.local.AccountEntity
import kotlinx.coroutines.launch
import java.util.*

class AccountViewModel : ViewModel() {

    private val usecase by lazy {
        getAccountUsecase()
    }

    private val account: MutableLiveData<AccountEntity> = MutableLiveData()
    val accountLiveData: LiveData<AccountEntity> = account

    fun account(accountBalance: Int) {
        viewModelScope.launch {
            val user = usecase.account(accountBalance = accountBalance)
            Log.e("ACCOUNT ", user.toString())
        }

    }

    fun add() {

    }
    /*account.value = accountCreated*/
}
