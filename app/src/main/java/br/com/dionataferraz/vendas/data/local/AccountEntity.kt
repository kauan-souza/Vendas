package br.com.dionataferraz.vendas.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "accountTable")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val accountBalance: Int,
    val type: Type,
    val date: String
)

