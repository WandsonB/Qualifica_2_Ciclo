package com.swt.qualifica_2_ciclo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            goRegister()
        }

        val btnLostPass = findViewById<Button>(R.id.btnLostPass)
        btnLostPass.setOnClickListener {
            goRegister()
        }
    }

    private fun goRegister() {
        val goRegister = Intent(this, registerActivity::class.java)
        startActivity(goRegister)
    }
}