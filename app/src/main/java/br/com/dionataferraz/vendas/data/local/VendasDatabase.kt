package br.com.dionataferraz.vendas.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.dionataferraz.vendas.App

@Database(entities = [AccountEntity::class], version = 1)
abstract class VendasDatabase : RoomDatabase() {

    abstract fun DAO(): AccountDao

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