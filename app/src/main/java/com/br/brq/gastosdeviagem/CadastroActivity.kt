package com.br.brq.gastosdeviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_cadastro.*
import java.sql.RowId

class CadastroActivity : AppCompatActivity() {

    lateinit var nome: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var telefone: TextInputEditText
    lateinit var senha: TextInputEditText
    lateinit var btnCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        carregarElemento()
        carregarEvento()

    }

    fun carregarElemento() {
        nome = findViewById(R.id.editNome)
        email = findViewById(R.id.editEmail)
        telefone = findViewById(R.id.editTelefone)
        senha = findViewById(R.id.editSenha)
        btnCadastrar = findViewById(R.id.btnCadastrar)
    }

    fun validarNome(): Boolean {
        return nome.text.toString() != ""
    }

    fun validarEmail(): Boolean {
        return email.text.toString().contains("@") && email.text.toString().contains(".com")
    }

    fun validarTelefone(): Boolean {
        return telefone.toString().length >= 9
    }

    fun validarSenha(): Boolean {
        return senha.toString().length >= 8
    }

    fun carregarEvento() {

        btnCadastrar.setOnClickListener() {
            val isNameValid = validarNome()
            val isEmailValid = validarEmail()
            val isTelefoneValid = validarTelefone()
            val isSenhaValid = validarSenha()

            if (validarNome() && validarEmail() && validarTelefone() && validarSenha()) {

            if (isNameValid && isEmailValid && isTelefoneValid && isSenhaValid) {

                finish()

            } else {
                if (!isNameValid) {
                    nome.setError("Campo Inválido")

                } else if (!isEmailValid) {
                    email.setError("Email invávilo")

                } else if (!isTelefoneValid) {
                    telefone.setError("Telefone Inválido")

                } else if (!isSenhaValid) {
                    senha.setError("Senha inválida")
                }
                Toast.makeText(this, "Informação inválida", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

}