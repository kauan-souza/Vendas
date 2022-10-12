package br.com.dionataferraz.vendas.login.data.local

import br.com.dionataferraz.vendas.VendasDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import br.com.dionataferraz.vendas.model.NotFoundUser
import br.com.dionataferraz.vendas.model.UserModel
import br.com.dionataferraz.vendas.model.ResultModel

class LoginLocalDataSource {

    private val database by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun insertUser(userModel: UserModel) {
        withContext(Dispatchers.IO) {
            database.loginDAO().insertUser(
                userModel.mapModelToEntity()
            )
        }
    }

    suspend fun getUser(): ResultModel<UserModel, NotFoundUser> {
        return withContext(Dispatchers.IO) {
            val listUser = database.loginDAO().getUser()

            if (listUser.isEmpty()) {
                ResultModel.Error(NotFoundUser)
            } else {
                ResultModel.Success(listUser.first().mapEntityToModel())
            }
        }
    }

    private fun UserEntity.mapEntityToModel(): UserModel {
        return UserModel(
            name = name,
            email = email,
            password = password
        )
    }

    private fun UserModel.mapModelToEntity(): UserEntity {
        return UserEntity(
            name = name,
            email = email,
            password = password
        )
    }
}