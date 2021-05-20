package com.br.brq.gastosdeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_calculo_gasolina.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_hospedagem.*
import java.lang.NumberFormatException

class HospedagemActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospedagem)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btnCalcularHotel.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnCalcularHotel) {
            totalResult()
        }
    }

    fun totalResult() {
        if (validarCampo()) {
            try {
                val valorDiaria =
                    editDiaria.isTextInputLayoutFocusedRectEnabled.toString().toFloat()
                val qtdeDiaria =
                    editQDiaria.isTextInputLayoutFocusedRectEnabled.toString().toFloat()

                val totalDiaria = qtdeDiaria * valorDiaria
                totalResultadoHotel.text = "R$ ${"%.2f".format(totalDiaria)}"
            } catch (num: NumberFormatException) {
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

    fun validarCampo(): Boolean {
        return (editDiaria.text.toString() != "" && editQDiaria.text.toString() != "")
    }

}
