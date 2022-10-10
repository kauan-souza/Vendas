package br.com.dionataferraz.vendas.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.data.domain.usecase.GetAccountUsecase
import br.com.dionataferraz.vendas.data.local.AccountModel
import br.com.dionataferraz.vendas.data.local.Type
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {

    private val usecase by lazy {
        GetAccountUsecase()
    }

    private val account: MutableLiveData<List<AccountModel>> = MutableLiveData()
    val accountLiveData: LiveData<List<AccountModel>> = account

    init {
        buscar()
    }

    private fun buscar() {
        viewModelScope.launch {

            val transacoes = usecase.buscar()
            account.value = transacoes

        }

    }

}