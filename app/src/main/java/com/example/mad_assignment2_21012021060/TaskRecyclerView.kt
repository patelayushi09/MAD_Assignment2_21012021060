package com.example.mad_assignment2_21012021060
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TaskRecyclerView(private val taskList: MutableList<TaskItem>) : RecyclerView.Adapter<TaskRecyclerView.TaskViewHolder>() {
    lateinit var sqLiteHelper: SQLiteHelper
   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskRecyclerView.TaskViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.task_row_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskRecyclerView.TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.titleTextView.text = task.title
        holder.priorityTextView.text = task.priority
        holder.duedateTextView.text = task.duedate

        holder.linearLayout.setOnClickListener {
            val intent = Intent(it.context, DescriptionActivity::class.java)
            intent.putExtra("description",task.description)
            it.context.startActivity(intent)
        }

        holder.deleteTask.setOnClickListener {
            sqLiteHelper = SQLiteHelper(it.context)
            sqLiteHelper.deleteTask(task.title)
            Toast.makeText(it.context,"Task deleted successfully!",Toast.LENGTH_SHORT).show()
//            it.context.startActivity(Intent(it.context, MainActivity::class.java))
            taskList.removeAt(position)
            notifyDataSetChanged()
        }

        holder.taskEdit.setOnClickListener {
            var intent = Intent(it.context,UpdateTaskActivity::class.java)
            intent.putExtra("title",task.title)
            intent.putExtra("description",task.description)
            intent.putExtra("priority",task.priority)
            intent.putExtra("duedate",task.duedate)


            it.context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int {
        return taskList.size
    }

    inner class TaskViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        val titleTextView: TextView = itemView.findViewById(R.id.task_title)
        val priorityTextView : TextView = itemView.findViewById(R.id.task_priority)
        val duedateTextView : TextView = itemView.findViewById(R.id.task_duedate)
        val linearLayout: LinearLayout = itemView.findViewById(R.id.taskLayout)
        val taskEdit : ImageView = itemView.findViewById(R.id.taskEdit)
        val deleteTask : ImageView = itemView.findViewById(R.id.taskDelete)
    }
}