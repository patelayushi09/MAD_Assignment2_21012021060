package com.example.mad_assignment2_21012021060



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var sqLiteHelper: SQLiteHelper
    private var taskList: MutableList<TaskItem> = ArrayList()
    private lateinit var adapter: TaskRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnAddTask : Button = findViewById(R.id.addTaskBtn)
        val taskRecyclerView : RecyclerView = findViewById(R.id.taskRecycler)

        sqLiteHelper = SQLiteHelper(this)
        taskList = sqLiteHelper.getTasks()

        taskRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter =TaskRecyclerView(taskList)
        taskRecyclerView.adapter = adapter


        btnAddTask.setOnClickListener {
            startActivity(Intent(this@MainActivity,AddTaskActivity::class.java))
        }
    }

}

