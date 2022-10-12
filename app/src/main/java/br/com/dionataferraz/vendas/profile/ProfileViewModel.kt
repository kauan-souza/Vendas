package br.com.dionataferraz.vendas.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.profile.domain.usecase.ProfileUseCase
import kotlinx.coroutines.launch
class ProfileViewModel : ViewModel() {

    private val usecase by lazy {
        ProfileUseCase()
    }

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val userCreated: MutableLiveData<Boolean> = MutableLiveData(false)
    val userCreatedLiveData: LiveData<Boolean> = userCreated

    fun createPerson(userModel: UserModel) {
        viewModelScope.launch {
            if (userModel.name.isBlank()) {
                error.value = "nome não pode ser vazio!"
            } else if (userModel.email.isBlank()) {
                error.value = "email não pode ser vazio!"
            } else if (userModel.password.isBlank()) {
                error.value = "senha não pode ser vazio!"
            } else {
                usecase.registerProfile(userModel)
                userCreated.value = true
            }
        }
    }
}

