package br.com.dionataferraz.vendas.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.splash.domain.usecase.SplashUsecase
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val splash: MutableLiveData<Boolean> = MutableLiveData(false)
    val splashLiveData: MutableLiveData<Boolean> = splash

    private val usecase by lazy {
        SplashUsecase()
    }

    fun verifyIfUserExists() {
        viewModelScope.launch {
            splash.value = usecase.findUser().isEmpty()
        }
    }
}