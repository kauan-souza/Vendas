package br.com.dionataferraz.vendas

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.dionataferraz.vendas.account.data.local.AccountDao
import br.com.dionataferraz.vendas.account.data.local.AccountEntity
import br.com.dionataferraz.vendas.login.data.local.UserDao
import br.com.dionataferraz.vendas.login.data.local.UserEntity
import br.com.dionataferraz.vendas.splash.data.local.SplashDao


@Database(entities = [AccountEntity::class, UserEntity::class], version = 1)
abstract class VendasDatabase : RoomDatabase() {

    abstract fun DAO(): AccountDao
    abstract fun loginDAO(): UserDao
    abstract fun splashDAO(): SplashDao

    companion object {
        fun getInstance(): VendasDatabase {
            return Room.databaseBuilder(
                App.context,
                VendasDatabase::class.java,
                "vendas.db"
            ).build()
        }
    }
}