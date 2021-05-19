package com.br.brq.gastosdeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView




    lateinit var valorDiaria : EditText
    lateinit var qtdeDiaria : EditText
    lateinit var totGasto : TextView


class HospedagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospedagem)

        fun carregarElementos(){
            valorDiaria = findViewById(R.id.editDiaria)
            qtdeDiaria = findViewById(R.id.editQDiaria)
            totGasto = findViewById(R.id.totGasto)
        }

        fun validarEntrada(): Boolean {
            return (.text.toString() != "" && .text.toString() != "")

        var diaria = valorDiaria.toString().toFloat()
        var qdiaria = qtdeDiaria.toString().toFloat()








    }



}