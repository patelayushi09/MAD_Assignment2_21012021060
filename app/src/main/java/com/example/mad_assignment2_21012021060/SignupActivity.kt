package com.example.mad_assignment2_21012021060

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val name:EditText=findViewById(R.id.edittextName)
        val email:EditText=findViewById(R.id.edittextEmail)
        val password:EditText=findViewById(R.id.edittextPassword)
        val confirmPassword:EditText=findViewById(R.id.edittextCpass)

        val n:TextInputLayout=findViewById(R.id.textInputName)
        val e:TextInputLayout=findViewById(R.id.textInputEmail)
        val p:TextInputLayout=findViewById(R.id.textInputPassword)
        val cp:TextInputLayout=findViewById(R.id.textInputConfirmPassword)


        val databaseHelper = DatabaseHelper(this@SignupActivity)
        val inputValidation = InputValidation(this@SignupActivity)
        val user = User()

        val register:Button=findViewById(R.id.buttonreg)
        register.setOnClickListener {
            fun onClick(view: View?) {
                if (!inputValidation.isInputEditTextFilled(name, n, "Enter full name")) {
                    return
                }
                if (!inputValidation.isInputEditTextFilled(email, e, "Enter valid email")) {
                    return
                }
                if (!inputValidation.isInputEditTextEmail(email, e, "Enter valid email")) {
                    return
                }
                if (!inputValidation.isInputEditTextFilled(password, p, "Enter password")) {
                    return
                }
                if (!inputValidation.isInputEditTextMatches(password, confirmPassword, cp, "Entered Password doesn`t matches")) {
                    return
                }
                if (!databaseHelper.checkUser(email.text.toString().trim { it <= ' ' })) {
                    user.setName(name.text.toString().trim { it <= ' ' })
                    user.setEmail(email.text.toString().trim { it <= ' ' })
                    user.setPassword(password.getText().toString().trim { it <= ' ' })
                    databaseHelper.addUser(user)
                    Toast.makeText(this@SignupActivity, "Registration Successful", Toast.LENGTH_LONG).show()
                    //  emptyInputEditText();
                    val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    // if record already exists then
                    Toast.makeText(this@SignupActivity, getString(R.string.error_email_exists), Toast.LENGTH_LONG).show()
                }
            }

            }


        val alreadyexisttxt:TextView=findViewById(R.id.textalready)
        alreadyexisttxt.setOnClickListener {
            Intent(this@SignupActivity,MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}