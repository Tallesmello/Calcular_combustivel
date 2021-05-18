package com.br.brq.gastosdeviagem

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button
    lateinit var btnCadastreSe: Button
    lateinit var email: EditText
    lateinit var senha: EditText


    fun carregarElemento() {
        email = findViewById(R.id.editEmail)
        senha = findViewById(R.id.editSenha)
        btnEntrar = findViewById(R.id.buttonEntrar)
        btnCadastreSe = findViewById(R.id.buttonCadastreSe)

    }

    fun validarEmail(): Boolean {
        return email.toString().contains("@") && email.toString().contains(".com")
    }

    fun validarSenha(): Boolean {
        return senha.toString().length >= 8
    }


    fun carregarEvento() {
        btnEntrar.setOnClickListener() {


            if (validarEmail() && validarSenha()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Email ou Senha Inválido", Toast.LENGTH_LONG)
                    .show()
            }


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun carregarCadastro() {
        btnCadastreSe.setOnClickListener() {

            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        carregarElemento()
        carregarEvento()
        carregarCadastro()


    }


}

