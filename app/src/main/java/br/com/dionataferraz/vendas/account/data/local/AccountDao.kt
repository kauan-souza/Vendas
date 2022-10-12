package br.com.dionataferraz.vendas.account.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {

    @Insert
    fun insertAccount(accountEntity: AccountEntity)

    @Query("SELECT * from accountTable ORDER BY id desc")
    fun getAccount(): List<AccountEntity>

    @Query("SELECT SUM(t.accountBalance) AS valorTotal FROM accountTable t")
    fun findBalance(): Double
}