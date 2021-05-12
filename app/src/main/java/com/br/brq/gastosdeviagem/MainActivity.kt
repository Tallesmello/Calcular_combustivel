package com.br.brq.gastosdeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalcular) {
            calcular()
        }
    }

    private fun calcular() {
        if (validacaoOk()) {

            try {
                val distance = distanciaTotal.text.toString().toFloat()
                val price = precoR.text.toString().toFloat()
                val autonomy = autonomiaTotal.text.toString().toFloat()

                val valorTotal = (distance * price) / autonomy
                totalResultado.text = "R$ ${"%.2f".format(valorTotal)}"
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
        return (distanciaTotal.text.toString() != "" && precoR.text.toString() != "" && autonomiaTotal.text.toString() != "" && autonomiaTotal.text.toString() != "0")
    }
}