package br.com.dionataferraz.vendas.splash.data.local


import br.com.dionataferraz.vendas.VendasDatabase
import br.com.dionataferraz.vendas.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SplashLocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun findUser(): List<UserModel> {
        return withContext(Dispatchers.IO) {
            database.splashDAO().getUser()
        }
    }
}