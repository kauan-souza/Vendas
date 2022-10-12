package br.com.dionataferraz.vendas.account.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accountTable")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val accountBalance: Double,
    val type: Type,
    val date: String
)

