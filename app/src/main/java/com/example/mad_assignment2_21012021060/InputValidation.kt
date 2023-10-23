package com.example.mad_assignment2_21012021060

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class InputValidation {

    private var context: Context? = null
    fun InputValidation(context: Context?) {
        this.context = context
    }


    // method to check inputEditText filled
    fun isInputEditTextFilled(
        textInputEditText: EditText,
        textInputLayout: TextInputLayout,
        message: String?
    ): Boolean {
        val v = textInputEditText.text.toString().trim { it <= ' ' }
        if (v.isEmpty()) {
            textInputLayout.error = message
            //hidekeyboardFrom(textInputEditText);
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return true
    }

    // method to check inputEditText  has valid email
    fun isInputEditTextEmail(
        textInputEditText: EditText,
        textInputLayout: TextInputLayout,
        message: String?
    ): Boolean {
        val v = textInputEditText.text.toString().trim { it <= ' ' }
        if (v.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(v).matches()) {
            textInputLayout.error = message
            //hidekeyboardFrom(textInputEditText);
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return true
    }

    fun isInputEditTextMatches(
        textInputEditText1: EditText,
        textInputEditText2: EditText,
        textInputLayout: TextInputLayout,
        message: String?
    ): Boolean {
        val v1 = textInputEditText1.text.toString().trim { it <= ' ' }
        val v2 = textInputEditText2.text.toString().trim { it <= ' ' }
        if (!v1.contentEquals(v2)) {
            textInputLayout.error = message
            //hidekeyboardFrom(textInputEditText2);
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return true
    }
}