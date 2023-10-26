package com.example.mad_assignment2_21012021060

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var databaseHelper:DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var registerTxt : TextView = findViewById(R.id.registerText)
        registerTxt.setOnClickListener {
            startActivity(Intent(this@LoginActivity,SignupActivity::class.java))
        }

        val loginBtn : Button = findViewById(R.id.loginBtn)

        val eEmail: EditText =findViewById(R.id.editTextEmail)
        val ePassword: EditText =findViewById(R.id.editTextPassword)

        val tEmail: TextInputLayout =findViewById(R.id.textInputEmail)
        val tPassword: TextInputLayout =findViewById(R.id.textInputPassword)

        loginBtn.setOnClickListener {

            if(!eEmail.text.trim().isEmpty())
            {
                tEmail.isErrorEnabled=false
            }
            if(!ePassword.text.trim().isEmpty())
            {
                tPassword.isErrorEnabled=false
            }

            databaseHelper = DatabaseHelper(this)

            var name = databaseHelper.getNameFromEmail(eEmail.text.toString())


            if(eEmail.text.trim().isEmpty())
            {
                tEmail.error = "Please enter your email"
            }
            else if(ePassword.text.trim().isEmpty())
            {
                tPassword.error = "Please enter password"
            }
            else if(name!=null)
            {
                var password = databaseHelper.getPasswordFromEmail(eEmail.text.toString())
                if(password==ePassword.text.toString())
                {
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                }
                else
                {
                    tPassword.error = "Password wrong!!"
                }
            }
            else
            {
                tEmail.error = "email does not exists!!"
            }
        }
    }


}
