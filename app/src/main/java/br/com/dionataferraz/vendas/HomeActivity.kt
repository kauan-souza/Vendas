package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.account.AccountActivity
import br.com.dionataferraz.vendas.databinding.ActivityHomeBinding
import br.com.dionataferraz.vendas.transactions.TransactionsActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityHomeBinding.inflate(layoutInflater).run {
            binding = this
            setContentView(root)
        }

        binding.btSave2.setOnClickListener() {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }
        binding.btSave3.setOnClickListener() {
            val intent = Intent(this, TransactionsActivity::class.java)
            startActivity(intent)
        }
    }
}