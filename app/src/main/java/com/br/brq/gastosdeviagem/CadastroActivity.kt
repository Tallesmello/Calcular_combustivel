package com.br.brq.gastosdeviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import java.sql.RowId

class CadastroActivity : AppCompatActivity() {

    lateinit var nome: EditText
    lateinit var email: EditText
    lateinit var telefone: EditText
    lateinit var senha: EditText

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
        senha = findViewById(R.id.editSenha)
        telefone = findViewById(R.id.editTelefone)
    }

    fun validarNome(): Boolean {
        return nome.text.contains("")
    }

    fun validarEmail(): Boolean {
        return email.toString().contains("@") && email.toString().contains(".com")
    }

    fun validarTelefone(): Boolean {
        return telefone.toString().length >= 11
    }

    fun validarSenha(): Boolean {
        return senha.toString().length >= 8
    }

    fun carregarEvento() {

        btnCadastrar.setOnClickListener() {

            if (validarNome() && validarEmail() && validarTelefone() && validarSenha()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Informação inválida", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

//    fun carregarBtnCadastrar() {
//        btnCadastrar.setOnClickListener() {
//
//
//
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
//    }

}