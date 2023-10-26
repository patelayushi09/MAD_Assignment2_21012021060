package com.example.mad_assignment2_21012021060

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var databaseHelper:DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var loginTxt :TextView = findViewById(R.id.loginText);
        loginTxt.setOnClickListener {
            startActivity(Intent(this@SignupActivity,LoginActivity::class.java))
        }

        val registerBtn : Button = findViewById(R.id.registerBtn)
        val eName: EditText =findViewById(R.id.editTextName)
        val eEmail: EditText =findViewById(R.id.editTextEmail)
        val ePassword: EditText =findViewById(R.id.editTextPassword)
        val eConfirmPassword: EditText =findViewById(R.id.editTextConfirmPassword)

        val tName: TextInputLayout =findViewById(R.id.textInputName)
        val tEmail: TextInputLayout =findViewById(R.id.textInputEmail)
        val tPassword: TextInputLayout =findViewById(R.id.textInputPassword)
        val tConfirmPassword: TextInputLayout =findViewById(R.id.textInputConfirmPassword)

        databaseHelper = DatabaseHelper(this)


        registerBtn.setOnClickListener {

            var name = databaseHelper.getNameFromEmail(eEmail.text.toString())

            if(!eName.text.trim().isEmpty())
            {
                tName.isErrorEnabled=false
            }
            if(!eEmail.text.trim().isEmpty())
            {
                tEmail.isErrorEnabled=false
            }
            if(!ePassword.text.trim().isEmpty())
            {
                tPassword.isErrorEnabled=false
            }
            if(!eConfirmPassword.text.trim().isEmpty())
            {
                tConfirmPassword.isErrorEnabled=false
            }
            if(!(ePassword.text.toString()!=eConfirmPassword.text.toString()))
            {
                tConfirmPassword.isErrorEnabled=false
            }



            if(eName.text.trim().isEmpty())
            {
                tName.error = "Please enter your name"
            }
            else if(eEmail.text.trim().isEmpty())
            {
                tEmail.error = "Please enter your email"
            }

            else if(ePassword.text.trim().isEmpty())
            {
                tPassword.error = "Please enter password"
            }

            else if(eConfirmPassword.text.trim().isEmpty())
            {
                tConfirmPassword.error = "Please enter confirm password"
            }
            else if(ePassword.text.toString()!=eConfirmPassword.text.toString())
            {
                tConfirmPassword.error = "Does not match with password"
            }
            else if(name!=null)
            {
                tEmail.error = "Email already exists!"
            }
            else
            {
                databaseHelper.addUser(eName.text.toString(), eEmail.text.toString(), ePassword.text.toString())
                startActivity(Intent(this@SignupActivity,MainActivity::class.java))
                Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show()
            }
        }

    }


}