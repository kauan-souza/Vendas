package br.com.dionataferraz.vendas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {

    @Insert
    fun insertAccount(accountEntity: AccountEntity)

    @Query("SELECT * from accountTable")
    fun getAccount(): List<AccountEntity>
}