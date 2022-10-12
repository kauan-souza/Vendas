package br.com.dionataferraz.vendas.login.data.repository

import br.com.dionataferraz.vendas.login.data.local.LoginLocalDataSource
import br.com.dionataferraz.vendas.login.data.remote.LoginRemoteDataSource
import br.com.dionataferraz.vendas.model.*

class LoginRepository {

    private val dataSource by lazy {
        LoginRemoteDataSource()
    }

    private val localdataSource by lazy {
        LoginLocalDataSource()
    }

    suspend fun login(loginModel: LoginModel): ResultModel<UserModel, ErrorModel> {

        val resultModelUser = dataSource.login(
            password = loginModel.password,
            email = loginModel.email
        )
        if (resultModelUser is ResultModel.Success) {
            insertUser(resultModelUser.value)
        }
        return resultModelUser
    }

    private suspend fun insertUser(userModel: UserModel) {

        localdataSource.insertUser(
            userModel
        )
    }

    suspend fun getUser(): ResultModel<UserModel, NotFoundUser> {

        return localdataSource.getUser()
    }
}