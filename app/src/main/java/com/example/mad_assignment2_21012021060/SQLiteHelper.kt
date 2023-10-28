package com.example.mad_assignment2_21012021060
/*
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "tasks.db"
        private const val TABLE_NAME = "task"
        private const val COLUMN_TASK_ID = "task_id"
        private const val COLUMN_TASK_TITLE = "task_title"
        private const val COLUMN_TASK_DESCRIPTION = "task_description"
        private const val COLUMN_TASK_DUEDATE = "task_duedate"
        private const val COLUMN_TASK_PRIORITY = "task_priority"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE ${SQLiteHelper.TABLE_NAME}(${SQLiteHelper.COLUMN_TASK_ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${SQLiteHelper.COLUMN_TASK_TITLE} TEXT, ${SQLiteHelper.COLUMN_TASK_DESCRIPTION} TEXT, ${SQLiteHelper.COLUMN_TASK_DUEDATE} TEXT, ${SQLiteHelper.COLUMN_TASK_PRIORITY} TEXT)"
        if (db != null) {
            db.execSQL(createTableQuery)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS ${SQLiteHelper.TABLE_NAME}")
        }
    }

    fun addTask(title:String, description:String, dueDtae:String, priority:String) {
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(SQLiteHelper.COLUMN_TASK_TITLE, title)
        values.put(SQLiteHelper.COLUMN_TASK_DESCRIPTION, description)
        values.put(SQLiteHelper.COLUMN_TASK_DUEDATE, dueDtae)
        values.put(SQLiteHelper.COLUMN_TASK_PRIORITY, priority)

        // inserting rows in a table
        db.insert(SQLiteHelper.TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getTasks() : MutableList<TaskItem>
    {
        val tasksList = mutableListOf<TaskItem>()

        val db = readableDatabase
        var query = "SELECT * FROM ${SQLiteHelper.TABLE_NAME}"
        var cursor : Cursor =db.rawQuery(query,null)

        while (cursor.moveToNext())
        {
            var title : String? = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_TITLE))
            var description : String? = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DESCRIPTION))
            var duedate : String? = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_DUEDATE))
            var priority: String? = cursor.getString(cursor.getColumnIndex(COLUMN_TASK_PRIORITY))

            title = title?:""
            description = description?:""
            duedate = duedate?:""
            priority = priority?:""

            var item = TaskItem(title,description,duedate,priority)
            tasksList.add(item)
        }
        cursor.close()
        db.close()
        return tasksList
    }

    fun deleteTask(title : String) : Int
    {
        val db = writableDatabase
        val selection = "$COLUMN_TASK_TITLE = ?"
        val selectionArgs = arrayOf(title)

        val count = db.delete(TABLE_NAME, selection,selectionArgs)
        db.close()
        return count
    }

    fun updateTask(oldTitle: String, newTitle:String, description: String, dueDate: String, priority: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TASK_TITLE, newTitle)
        values.put(COLUMN_TASK_DESCRIPTION, description)
        values.put(COLUMN_TASK_DUEDATE, dueDate)
        values.put(COLUMN_TASK_PRIORITY, priority)

        db.update(TABLE_NAME, values, "$COLUMN_TASK_TITLE=?", arrayOf(oldTitle))
        db.close()
    }

}

 */