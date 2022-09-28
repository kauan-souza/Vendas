package br.com.dionataferraz.vendas

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.data.local.AccountEntity
import br.com.dionataferraz.vendas.data.local.VendasDatabase
import br.com.dionataferraz.vendas.databinding.ActivityAccountBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding
    private lateinit var viewModel: AccountViewModel

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_account)
        viewModel = AccountViewModel()

        val view = binding.root
        setContentView(view)

        binding.btAdd.setOnClickListener {
            val accountBalance = binding.etValue.text.toString()
        }
            viewModel.accountLiveData.observe(this) { account ->


        }

        val aaa = AccountEntity(accountBalance = 100)

//        CoroutineScope(Dispatchers.IO).launch {
//
//            database.DAO().insertAccount(aaa)
//
//            val account = database.DAO().getAccount()
//            Log.e("DAO ", account.toString())
//
//        }
    }

}