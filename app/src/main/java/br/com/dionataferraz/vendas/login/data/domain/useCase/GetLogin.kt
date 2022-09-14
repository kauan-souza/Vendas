package br.com.dionataferraz.vendas.login.data.domain.useCase

import br.com.dionataferraz.vendas.login.data.Repository.LoginRepository
import br.com.dionataferraz.vendas.login.data.remote.ErrorModel
import br.com.dionataferraz.vendas.login.data.remote.Result
import br.com.dionataferraz.vendas.login.data.response.UserResponse

class GetLoginUseCase {

    private val repository by lazy {
        LoginRepository()
    }

    suspend fun login(email: String, password: String): Result<UserResponse, ErrorModel> {
        return repository.login(email = email, password = password)
    }
}