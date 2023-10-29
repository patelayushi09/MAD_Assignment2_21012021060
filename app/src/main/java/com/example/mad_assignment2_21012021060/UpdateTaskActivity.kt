package com.example.mad_assignment2_21012021060

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class UpdateTaskActivity : AppCompatActivity() {
    lateinit var sqLiteHelper: SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_task)

        val btnUpdateTask : Button = findViewById(R.id.buttonUpdateTask)

        val taskTitle : EditText = findViewById(R.id.editTextTitle)
        val taskDescription : EditText = findViewById(R.id.editTextDescription)
        val taskDueDate : EditText = findViewById(R.id.editTextDueDate)
        val taskPriority : Spinner = findViewById(R.id.spinnerPriority)

        val titleString = intent.getStringExtra("title")
        taskTitle.setText(titleString)

        val descriptionString = intent.getStringExtra("description")
        taskDescription.setText(descriptionString)

        val dueDateString = intent.getStringExtra("duedate")
        taskDueDate.setText(dueDateString)

        val priorityString = intent.getStringExtra("priority")
        val adapter = taskPriority.adapter
        if (adapter is ArrayAdapter<*>) {
            val position = (adapter as ArrayAdapter<String>).getPosition(priorityString)
            if (position != -1) {
                taskPriority.setSelection(position)
            }
        }

        btnUpdateTask.setOnClickListener {
            sqLiteHelper = SQLiteHelper(this)

            if(taskTitle.text.trim().isEmpty())
                Snackbar.make(it.rootView,"Please enter title!!",Snackbar.LENGTH_SHORT).show()

            else if(taskDescription.text.trim().isEmpty())
                Snackbar.make(it.rootView,"Please enter description!!", Snackbar.LENGTH_SHORT).show()

            else if(taskDueDate.text.trim().isEmpty())
                Snackbar.make(it.rootView,"Please enter due date!!", Snackbar.LENGTH_SHORT).show()

            else
            {
                Toast.makeText(this, "Task updated successfully!", Toast.LENGTH_SHORT).show()
                if (titleString != null) {
                    sqLiteHelper.updateTask(titleString,taskTitle.text.toString(), taskDescription.text.toString(), taskDueDate.text.toString(),taskPriority.selectedItem.toString())
                }
                startActivity(Intent(this@UpdateTaskActivity,MainActivity::class.java))
            }
        }

    }
}