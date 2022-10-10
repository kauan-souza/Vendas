package br.com.dionataferraz.vendas.transactions

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.TransactionAdapter
import br.com.dionataferraz.vendas.data.TransactionViewModel
import br.com.dionataferraz.vendas.databinding.ActivityTransactionsBinding

class TransactionsActivity : AppCompatActivity(), TransactionAdapter.Listener {

    private lateinit var binding: ActivityTransactionsBinding
    private lateinit var viewModel: TransactionViewModel


    private val adapter: TransactionAdapter by lazy {
        TransactionAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = TransactionViewModel()

        viewModel.accountLiveData.observe(this) {

            binding.rcList.adapter = adapter

            adapter.addList(it)
        }

    }

    override fun onItemClick(text: String) {
        Toast.makeText(
            this,
            text,
            Toast.LENGTH_LONG
        ).show()
    }
}