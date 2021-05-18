package com.br.brq.gastosdeviagem

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var btnEntrar: Button
    lateinit var btnCadastreSe: Button

    fun carregarElemento(){

        btnEntrar = findViewById(R.id.buttonEntrar)
        btnCadastreSe = findViewById(R.id.buttonCadastreSe)
    }

    fun carregarEvento() {
        btnEntrar.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun carregarCadastro(){
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

