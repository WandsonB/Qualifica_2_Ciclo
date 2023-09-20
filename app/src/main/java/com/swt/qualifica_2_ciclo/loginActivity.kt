package com.swt.qualifica_2_ciclo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val lgnEmail = findViewById<EditText>(R.id.editTextEmail).toString()
        val lgnPass = findViewById<EditText>(R.id.editTextPass).toString()
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val extName = intent.getStringExtra("name")
        val extEmail = intent.getStringExtra("email")
        val extPass = intent.getStringExtra("pass")

        btnLogin.setOnClickListener(View.OnClickListener{
            val extStrEmail = extEmail.toString()
            val extStrPass = extPass.toString()

            if (lgnEmail == extStrEmail && lgnPass == extStrPass) {
                Toast.makeText(this, "Login bem-sucedido! \n Bem-vindo ${extName}", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email ou senha incorretos.", Toast.LENGTH_SHORT).show()
            }
        })


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