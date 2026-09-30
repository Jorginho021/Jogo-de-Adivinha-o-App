package com.example.jogoadivinhacao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNome = findViewById<EditText>(R.id.etNome)
        val rgLimite = findViewById<RadioGroup>(R.id.rgLimite)
        val btnJogar = findViewById<Button>(R.id.btnJogar)

        btnJogar.setOnClickListener {
            val nome = etNome.text.toString().trim()

            if (nome.isEmpty()) {
                Toast.makeText(this, "Por favor, digite seu nome!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Descobre o limite escolhido no RadioGroup
            val maximo = when (rgLimite.checkedRadioButtonId) {
                R.id.rb10 -> 10
                R.id.rb50 -> 50
                R.id.rb100 -> 100
                else -> 10
            }

            // 2. NAVEGAR + 3. ENVIAR DADOS (putExtra)
            val intent = Intent(this, JogoActivity::class.java).apply {
                putExtra("nome", nome)
                putExtra("maximo", maximo)
            }
            startActivity(intent)
        }
    }
}
