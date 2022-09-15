package br.com.dionataferraz.vendas.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.login.data.domain.useCase.GetLoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val usecase by lazy {
        GetLoginUseCase()
    }

    private val error: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldShowError: LiveData<Boolean> = error

    private val home: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldShowHome: LiveData<Boolean> = home

    fun login(email: String?, password: String?) {
        viewModelScope.launch {
            if (email != null && password != null) {
                val user = usecase.login(email = email, password = password)
                if(user.get() != null){
                    home.value = true
                }
                Log.e("login", user.get().toString())
            } else {
                error.value = true
            }
        }
    }


}