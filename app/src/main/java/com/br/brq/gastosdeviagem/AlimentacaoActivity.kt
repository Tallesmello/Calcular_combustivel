package com.br.brq.gastosdeviagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alimentacao.*
import kotlinx.android.synthetic.main.activity_calculo_gasolina.*
import java.lang.NumberFormatException

class AlimentacaoActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alimentacao)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btnCalcularfood.setOnClickListener(this)
        finalizarFood.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnCalcularfood) {
            calcular()
        }
    }

    private fun calcular() {
        if (validacaoOk()) {

            try {
                val foodDiario = foodValor.text.toString().toFloat()
                val foodQuantosDias = quantosDias.text.toString().toFloat()

                val valorTotal = foodDiario * foodQuantosDias
                totalResultadoFood.text = "R$ ${"%.2f".format(valorTotal)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(
                    this,
                    getString(R.string.notificacao_informe_valor_valido),
                    Toast.LENGTH_LONG
                ).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.notificacao_insira_valores), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validacaoOk(): Boolean {
        return ( foodValor.text.toString() != "" && quantosDias.text.toString() != "")
    }

}