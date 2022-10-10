package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.data.domain.usecase.GetAccountUsecase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val getAccountUsecase by lazy {
        GetAccountUsecase()
    }

    private val balance: MutableLiveData<String> = MutableLiveData()
    val showBalance: LiveData<String> = balance

    fun getBalance() {
        viewModelScope.launch {
            balance.value = getAccountUsecase.findBalance().toCurrency()
        }
    }
}