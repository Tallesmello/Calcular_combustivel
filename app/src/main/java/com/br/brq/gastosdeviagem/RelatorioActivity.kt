package com.br.brq.gastosdeviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.br.brq.gastosdeviagem.R.id.totalResultadoHotel
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.view.*
import kotlinx.android.synthetic.main.activity_hospedagem.*

abstract class RelatorioActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btHospedagem: Button
    lateinit var btCombustivel: Button
    lateinit var btAlimentacao: Button
    lateinit var btTotalRelatorio: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatorio)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btHospedagem.setOnClickListener {

        }

        totalBtHospedagem()

        fun onClick(view: View) {
            val id = view.id
            if (id == R.id.totalResultadoHotel) {
                totalBtHospedagem()
            }

        }

    }

    private fun totalBtHospedagem() {
        val totalBtHospedagem = R.id.totalResultadoHotel
        println(totalBtHospedagem)
    }
}
