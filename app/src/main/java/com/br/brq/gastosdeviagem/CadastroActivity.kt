package com.br.brq.gastosdeviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import java.sql.RowId

class CadastroActivity : AppCompatActivity() {

    lateinit var nome: EditText
    lateinit var email: EditText
    lateinit var telefone: EditText
    lateinit var senha: EditText
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
            val isnameValid = validarNome()
            val istelefoneValid = validarNome()
            val isemailValid = validarNome()
            val issenhaValid = validarNome()

            if (isnameValid && istelefoneValid && isemailValid && issenhaValid) {
                finish()

            } else {
                if(!isnameValid ){
                    nome.setError("Campo Inválido")

                }else if (!istelefoneValid){
                    telefone.setError("Telefone Inválido")

                }else if (!isemailValid){
                    email.setError("Email invávilo")
                }else if (!issenhaValid){
                    senha.setError("Senha inválida")
                }
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