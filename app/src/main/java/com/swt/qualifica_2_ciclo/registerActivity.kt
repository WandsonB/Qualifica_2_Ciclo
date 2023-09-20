package com.swt.qualifica_2_ciclo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registerActivity : AppCompatActivity() {

    private var nome:String = ""
    private var email:String = ""
    private var pass:String = ""
    private var passConf:String = ""

    private lateinit var registName:EditText
    private lateinit var registEmail:EditText
    private lateinit var registPass:EditText
    private lateinit var registPassConf:EditText
    private lateinit var btnRegist: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registName = findViewById<EditText>(R.id.regisName)
        registEmail = findViewById<EditText>(R.id.regisEmail)
        registPass = findViewById<EditText>(R.id.regisPass)
        registPassConf = findViewById<EditText>(R.id.regisPassConf)
        btnRegist = findViewById<Button>(R.id.btnCadastro)

        btnRegist.setOnClickListener(View.OnClickListener{
            nome = registName.text.toString()
            email = registEmail.text.toString()
            pass = registPass.text.toString()
            passConf = registPassConf.text.toString()

            if (registPass == registPassConf){
                val intent = Intent(this, loginActivity::class.java)
                intent.putExtra("name",nome)
                intent.putExtra("email",email)
                intent.putExtra("pass",pass)
                val actLgn = Intent(this,loginActivity::class.java)


                if (nome.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()) {
                    Toast.makeText(this, "Cadastro feito com sucesso!", Toast.LENGTH_SHORT).show()
                    startActivity(actLgn)
                } else {
                    Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Senhas diferentes!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}