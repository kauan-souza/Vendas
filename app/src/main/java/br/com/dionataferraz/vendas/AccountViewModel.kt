package br.com.dionataferraz.vendas


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.data.domain.usecase.GetAccountUsecase
import br.com.dionataferraz.vendas.data.local.AccountEntity
import br.com.dionataferraz.vendas.data.local.Type
import kotlinx.coroutines.launch

class AccountViewModel : ViewModel() {

    private val usecase by lazy {
        GetAccountUsecase()
    }

    private val account: MutableLiveData<AccountEntity> = MutableLiveData()
    val accountLiveData: LiveData<AccountEntity> = account

    fun account(accountBalance: Int, type: Type, date: String) {
        viewModelScope.launch {

            val user = usecase.inserir(accountBalance = accountBalance, type = type, date = date)
            Log.e("ACCOUNT ", user.toString())
        }

    }


}
