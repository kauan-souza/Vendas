package br.com.dionataferraz.vendas

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.databinding.ActivityAccountBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

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

        binding.btBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences(
            "Profile",
            MODE_PRIVATE
        )

        val moshi = Moshi
            .Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val adapter = moshi
            .adapter(AccountActivity.Account::class.java)

        fun callProfileActivity() {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btSave.setOnClickListener {
            val radioGroup: RadioGroup = binding.rbAccount
            val radioButtonSelected: Int = radioGroup.checkedRadioButtonId
            val radioButton: RadioButton? = findViewById(radioButtonSelected)

            val nameAccount = binding.etDescription.text.toString()
            val accountBalance = binding.etValue.text.toString()
            val nameUser = binding.etResponsible.text.toString()
            val accountRB: String = radioButton?.text.toString()

           val aaa = viewModel.createAccount(
                nameAccount,
                accountBalance,
                nameUser ,
                accountRB
            )

            viewModel.accountLiveData.observe(this) { account ->
                val edit = sharedPreferences.edit()

                val personSave = adapter.toJson(account)
                edit.putString("Account", personSave)
                edit.apply()

                callProfileActivity()
            }
        }

    }

    data class Account(
        val nameAccount: String,
        val accountBalance: String,
        val nameUser: String,
        val accountRB: String
    )

    private fun configureActionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}