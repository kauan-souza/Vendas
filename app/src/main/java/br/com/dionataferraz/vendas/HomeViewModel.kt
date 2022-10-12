package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.account.data.domain.usecase.GetAccountUsecase
import br.com.dionataferraz.vendas.login.domain.usecase.GetLoginUsecase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val getAccountUsecase by lazy {
        GetAccountUsecase()
    }
    private val getLoginUsecase by lazy {
        GetLoginUsecase()
    }

    private val balance: MutableLiveData<String> = MutableLiveData()
    val showBalance: LiveData<String> = balance

    private val name: MutableLiveData<String> = MutableLiveData()
    val showName: LiveData<String> = name

    fun getNome() {
        viewModelScope.launch {
            name.value = "Olá, ${getLoginUsecase.getUser()?.name.toString()}"
        }
    }

    fun getBalance() {
        viewModelScope.launch {
            balance.value = getAccountUsecase.findBalance().toCurrency()
        }
    }
}