package com.example.mad_assignment2_21012021060

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class AddTaskActivity : AppCompatActivity() {
    lateinit var sqLiteHelper: SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val btnSaveTask : Button = findViewById(R.id.buttonSaveTask)

        val taskTitle : EditText = findViewById(R.id.editTextTitle)
        val taskDescription : EditText = findViewById(R.id.editTextDescription)
        val taskDueDate : EditText = findViewById(R.id.editTextDueDate)
        val taskPriority : Spinner = findViewById(R.id.spinnerPriority)


        btnSaveTask.setOnClickListener {
            sqLiteHelper = SQLiteHelper(this)

            if(taskTitle.text.trim().isEmpty())
                Snackbar.make(it.rootView,"Please enter title!!",Snackbar.LENGTH_SHORT).show()

            else if(taskDescription.text.trim().isEmpty())
                Snackbar.make(it.rootView,"Please enter description!!",Snackbar.LENGTH_SHORT).show()

            else if(taskDueDate.text.trim().isEmpty())
                Snackbar.make(it.rootView,"Please enter due date!!",Snackbar.LENGTH_SHORT).show()

            else
            {
                Toast.makeText(this, "Task saved successfully!", Toast.LENGTH_SHORT).show()
                sqLiteHelper.addTask(taskTitle.text.toString(), taskDescription.text.toString(), taskDueDate.text.toString(),taskPriority.selectedItem.toString())
                startActivity(Intent(this@AddTaskActivity,MainActivity::class.java))
            }
        }

    }
}