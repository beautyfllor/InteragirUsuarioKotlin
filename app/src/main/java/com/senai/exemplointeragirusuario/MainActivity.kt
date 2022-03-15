package com.senai.exemplointeragirusuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.senai.exemplointeragirusuario.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toastButton = findViewById<Button>(R.id.toast)
        toastButton.setOnClickListener {mensagemToast()}

//        val alertButton = findViewById<Button>(R.id.alert)
//        alertButton.setOnClickListener{mensagemAlert()}
//
//        val snackButton = findViewById<Button>(R.id.snack)
//        snackButton.setOnClickListener{mensagemSnack(snackButton)}

        //A forma abaixo não deve ser usada mais
        alert.setOnClickListener{mensagemAlert()}

        binding.snack.setOnClickListener {mensagemSnack(binding.snack)}
    }

    private fun mensagemSnack(snackButton: Button) {
        Snackbar.make(snackButton, "Teste mensagem SNACKBAR", Snackbar.LENGTH_INDEFINITE).setAction("SAIR"){finish()}.show()
    }

    private fun mensagemAlert() {
        AlertDialog.Builder(this).setTitle("Atenção!!!").setMessage("Deseja sair do APP?").setPositiveButton("Sim") {_,_-> finish()}
        .setNegativeButton("Cancelar") {_,_->}.show()
    }

    private fun mensagemToast() {
        Toast.makeText(this, "Teste de TOAST!", Toast.LENGTH_SHORT).show()
    }
}