package com.br.brq.gastosdeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_hospedagem.*
import kotlinx.android.synthetic.main.activity_hospedagem.totalHotel as toGasto1





class HospedagemActivity : AppCompatActivity() {
    lateinit var valorDiaria : TextInputEditText
    lateinit var qtdeDiaria : TextInputEditText
    lateinit var toGasto : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospedagem)

        carregarElementos()
        validarCampo()
        totResult()

    }

        fun carregarElementos(){
            valorDiaria = findViewById(R.id.editDiaria)
            qtdeDiaria = findViewById(R.id.editQDiaria)
             toGasto = findViewById(R.id.totalHotel)
        }

        fun validarCampo(): Boolean {
            return (valorDiaria.text.toString() != "" && qtdeDiaria.text.toString() != "")
        }

        fun totResult (){
            if(validarCampo()){
                try {
                val uDiaria = valorDiaria.toString().toFloat()
                val qDiaria = qtdeDiaria.toString().toFloat()
                val totalDiaria = qDiaria * uDiaria
                   toGasto.text = "R$ ${"%.2f".format(totalDiaria)}"
                }catch (num: NumberFormatException){
                    Toast.makeText(this,getString(R.string.notificacao_informe_valor_valido), Toast.LENGTH_LONG).show()
                }
                }else{
                Toast.makeText(this, getString(R.string.notificacao_insira_valores), Toast.LENGTH_LONG)
                    .show()
            }








        }











}