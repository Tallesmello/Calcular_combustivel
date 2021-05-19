package com.br.brq.gastosdeviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var btnHospedagem: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()


        }

        fun carregarEventos() {
            btnHospedagem = findViewById(R.id.inHospedagem)

        }

        fun clickHotel() {
            btnHospedagem.setOnClickListener() {
                val intent = Intent(this, HospedagemActivity::class.java)
                startActivity(intent)

            }


        }
    }
}





