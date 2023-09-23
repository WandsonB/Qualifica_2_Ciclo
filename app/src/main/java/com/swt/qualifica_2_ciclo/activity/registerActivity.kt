package com.swt.qualifica_2_ciclo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.swt.qualifica_2_ciclo.R

class registerActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var registName:EditText
    private lateinit var registEmail:EditText
    private lateinit var registPass:EditText
    private lateinit var registPassConf:EditText
    private lateinit var btnRegist: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        registName = findViewById<EditText>(R.id.regisName)
        registEmail = findViewById<EditText>(R.id.regisEmail)
        registPass = findViewById<EditText>(R.id.regisPass)
        registPassConf = findViewById<EditText>(R.id.regisPassConf)
        btnRegist = findViewById<Button>(R.id.btnCadastro)

        btnRegist.setOnClickListener(View.OnClickListener{
            val nome = registName.text.toString()
            val email = registEmail.text.toString()
            val pass = registPass.text.toString()
            val passConf = registPassConf.text.toString()

            if (pass == passConf){

                if (nome.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()) {
                    auth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(this){task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_SHORT).show()
                            val actLgn = Intent(this, loginActivity::class.java)
                            irParaLogin()                        }
                    }
                } else {
                    Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "As senhas devem ser iguais!", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun irParaLogin() {
        val intent = Intent(this, loginActivity::class.java)
        startActivity(intent)
    }
}