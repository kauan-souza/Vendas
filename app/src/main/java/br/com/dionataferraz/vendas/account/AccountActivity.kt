package br.com.dionataferraz.vendas.account

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.data.local.Type
import br.com.dionataferraz.vendas.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountBinding
    private lateinit var viewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_account)
        viewModel = AccountViewModel()

        val view = binding.root
        setContentView(view)

        binding.btAdd.setOnClickListener {
            val value = binding.etValue.text.toString()

            viewModel.account(value.toInt(), type = Type.DEPOSITO, date = "28/09/2022")

            Log.e("add ", value.toString())
        }

        binding.btRemove.setOnClickListener {
            val value = binding.etValue.text.toString()

            viewModel.account(value.toInt(), type = Type.SAQUE, date = "28/09/2022")
            Log.e("remove ", value.toString())
        }

//        fun soma() {
//            return
//            val list: List<AccountEntity> = listOf()
//            val valorRetirada =
//                list.filter { it.type == Type.RETIRADA }.sumOf { it.accountBalance }
//            val valorInserido =
//                list.filter { it.type == Type.INSERIR }.sumOf { it.accountBalance }
//        }
//        Toast.makeText(
//            this,
//            soma().toString(),
//            Toast.LENGTH_LONG
//        ).show()
//
  }

}