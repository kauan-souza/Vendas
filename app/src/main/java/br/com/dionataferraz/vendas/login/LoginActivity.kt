package br.com.dionataferraz.vendas.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.dionataferraz.vendas.HomeActivity
import br.com.dionataferraz.vendas.databinding.ActivityLoginBinding
import br.com.dionataferraz.vendas.model.LoginModel
import br.com.dionataferraz.vendas.profile.ProfileActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = LoginViewModel()

        val view = binding.root
        setContentView(view)

        binding.btLogin.setOnClickListener {
            viewModel.login(
                LoginModel(
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString()
                )
            )
        }

        viewModel.homeLiveData.observe(this) { it ->
            if (it) {
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        binding.btRegistrar.setOnClickListener {
            Intent(this, ProfileActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }


    }
}