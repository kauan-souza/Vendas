package br.com.dionataferraz.vendas.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.R
import br.com.dionataferraz.vendas.databinding.ActivityProfileBinding
import br.com.dionataferraz.vendas.login.LoginActivity
import br.com.dionataferraz.vendas.model.UserModel

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        viewModel = ProfileViewModel()

        setContentView(binding.root)

        binding.btSave.setOnClickListener {
            viewModel.createPerson(
                UserModel(
                    name = binding.etName.text.toString(),
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString()
                )
            )
        }

        viewModel.userCreatedLiveData.observe(this) { it ->
            if (it) {
                Intent(this, LoginActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

    }
}