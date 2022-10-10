package br.com.dionataferraz.vendas.account

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.R
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

        viewModel.exceptionLiveData.observe(this) { it ->
            when (it) {
                Error.Empty -> showToast("vazio")
                Error.InsufficientValue -> showToast("valor insuficiente")
            }
        }

        binding.btAdd.setOnClickListener {

            viewModel.deposito(
                accountBalance = binding.etValue.text.toString(),
            )

        }

        binding.btRemove.setOnClickListener {

            viewModel.saque(
                accountBalance = binding.etValue.text.toString(),
            )

        }

    }

    private fun showToast(msg: String) {
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
}