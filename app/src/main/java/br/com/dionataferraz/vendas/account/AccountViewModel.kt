package br.com.dionataferraz.vendas.account


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.data.domain.usecase.GetAccountUsecase
import br.com.dionataferraz.vendas.data.local.AccountEntity
import br.com.dionataferraz.vendas.data.local.Type
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AccountViewModel : ViewModel() {

    private val usecase by lazy {
        GetAccountUsecase()
    }

    private val account: MutableLiveData<AccountEntity> = MutableLiveData()
    val accountLiveData: LiveData<AccountEntity> = account

    private val exception: MutableLiveData<Error> = MutableLiveData()
    val exceptionLiveData: LiveData<Error> = exception



    fun saque(accountBalance: String) {
        viewModelScope.launch {

            val balance = usecase.findBalance()

                if (accountBalance > balance.toString()) {
                    account(
                        accountBalance = accountBalance.toDouble() * -1,
                        type = Type.SAQUE,
                    )
                }
            if(accountBalance.isBlank()){
                exception.value = Error.Empty
            }
            else {
                exception.value = Error.InsufficientValue
            }
        }

    }

    fun deposito(accountBalance: String) {
        account(
            accountBalance = accountBalance.toDouble(),
            type = Type.DEPOSITO,
        )

    }

    private fun account(accountBalance: Double, type: Type) {
        viewModelScope.launch {

            val aaa = usecase.findBalance()

            val user = usecase.inserir(
                accountBalance = accountBalance, type = type,
                date = SimpleDateFormat("yyyy-MM-dd").format(Date())
            )
            Log.e("ACCOUNT ", user.toString())
        }

    }

}
sealed class Error () {
    object Empty: Error()
    object InsufficientValue: Error()
}
