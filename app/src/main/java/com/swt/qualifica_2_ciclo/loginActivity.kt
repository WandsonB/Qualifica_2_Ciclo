package com.swt.qualifica_2_ciclo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class loginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        auth = FirebaseAuth.getInstance()

        val email = findViewById<EditText>(R.id.editTextEmail)
        val pass = findViewById<EditText>(R.id.editTextPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            goRegister()
        }
        val btnLostPass = findViewById<Button>(R.id.btnLostPass)
        btnLostPass.setOnClickListener {
            goRegister()
        }

        btnLogin.setOnClickListener(View.OnClickListener{

            val lgnEmail = email.text.toString()
            val lgnPass = pass.text.toString()

            auth.signInWithEmailAndPassword(lgnEmail, lgnPass)
                .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user: FirebaseUser? = auth.currentUser
                    if (user != null) {
                        val goMain = Intent(this, MainActivity::class.java)
                        goMain.putExtra("userId", user.uid) //importante
                        startActivity(goMain)
                        Toast.makeText(this,"Login bem-sucedido! \n Bem-vindo",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erro no login: ${task.exception?.message}", Toast.LENGTH_SHORT)
                        .show()
                    }
                }
            }
        })
    }

    private fun goRegister() {
        val goRegister = Intent(this, registerActivity::class.java)
        startActivity(goRegister)
    }
}