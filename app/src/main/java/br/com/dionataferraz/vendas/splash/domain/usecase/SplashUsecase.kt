package br.com.dionataferraz.vendas.splash.domain.usecase

import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.splash.data.repository.SplashRepository

class SplashUsecase {

    private val repository by lazy {
        SplashRepository()
    }

    suspend fun findUser(): List<UserModel> {
        return repository.findUser()
    }
}