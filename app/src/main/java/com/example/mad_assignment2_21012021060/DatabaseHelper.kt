package com.example.mad_assignment2_21012021060
/*
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper :  SQLiteOpenHelper(){
    companion object {
        // database version
        private val DATABASE_VERSION = 1

        // database name
        private val DATABASE_NAME = "UserManager.db"

        // table  name is user
        private val TABLE_USER = "user"

        // user table columns name
        private val COLUMN_USER_ID = "user_id"
        private val COLUMN_USER_NAME = "user_name"
        private val COLUMN_USER_EMAIL = "user_email"
        private val COLUMN_USER_PASSWORD = "user_password"
    }

    // query to create a table in SQLITE

    private var CREATE_USER_TABLE: String? =
        "CREATE TABLE " + DatabaseHelper.TABLE_USER + "(" + DatabaseHelper.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DatabaseHelper.COLUMN_USER_NAME + " TEXT," + DatabaseHelper.COLUMN_USER_EMAIL + " TEXT," + DatabaseHelper.COLUMN_USER_PASSWORD + " TEXT" + ")"


    // drop table query
    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS " + DatabaseHelper.TABLE_USER

    fun DatabaseHelper(context: Context?, name: String?, factory: CursorFactory?, version: Int) {
        super(context, name, factory, version)
    }

    //We make this another constructor and insert super method and its parameters
    fun DatabaseHelper(context: Context?) {
        super(context, DatabaseHelper.DATABASE_NAME, null, DatabaseHelper.DATABASE_VERSION)
    }

    fun onCreate(sqLiteDatabase: SQLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_USER_TABLE)
    }

    fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
     // drop user  table if exists
        sqLiteDatabase.execSQL(DROP_USER_TABLE)

        // create tables again
        onCreate(sqLiteDatabase)
    }

    @SuppressLint("Range")
    fun getNameFromEmail(email: String): String? {
        var name: String? = null
        val db: SQLiteDatabase = getReadableDatabase()
        val columns = arrayOf<String>(DatabaseHelper.COLUMN_USER_NAME)
        val selection: String = DatabaseHelper.COLUMN_USER_EMAIL + " = ?"
        val selectionArgs = arrayOf(email)
        val cursor =
            db.query(DatabaseHelper.TABLE_USER, columns, selection, selectionArgs, null, null, null)
        if (cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_USER_NAME))
        }
        cursor.close()
        return name
    }

    // method to create records
    fun addUser(user: User) {
        val db: SQLiteDatabase = this.getWritableDatabase()
        val values = ContentValues()
        values.put(DatabaseHelper.COLUMN_USER_NAME, user.getName())
        values.put(DatabaseHelper.COLUMN_USER_EMAIL, user.getEmail())
        values.put(DatabaseHelper.COLUMN_USER_PASSWORD, user.getPassword())

        // inserting rows in a table
        db.insert(DatabaseHelper.TABLE_USER, null, values)
        db.close()
    }

    // method to check user exists or not
    fun checkUser(email: String): Boolean {
        // array of columns to fetch
        val col = arrayOf<String>(DatabaseHelper.COLUMN_USER_ID)
        val db: SQLiteDatabase = this.getReadableDatabase()

        // selection criteria
        val selection: String = DatabaseHelper.COLUMN_USER_EMAIL + "= ?"

        // selection argument
        val args = arrayOf(email)

        // for result
        val cursor = db.query(DatabaseHelper.TABLE_USER, col, selection, args, null, null, null)
        // db.query(table to query,columns to return,columns for where clause,the values for where clause,
        // group the rows, filter by row groups, the sort order);
        val cursorcount = cursor.count
        cursor.close()
        return cursorcount > 0
    }

    fun checkUser(mail: String, pass: String): Boolean {
        val col = arrayOf<String>(DatabaseHelper.COLUMN_USER_ID)
        val db: SQLiteDatabase = this.getReadableDatabase()
        val selection: String =
            DatabaseHelper.COLUMN_USER_EMAIL + "= ?" + " AND " + DatabaseHelper.COLUMN_USER_PASSWORD + "= ?"
        val args = arrayOf(mail, pass)
        val cursor = db.query(DatabaseHelper.TABLE_USER, col, selection, args, null, null, null)
        val cursorcount = cursor.count
        cursor.close()
        db.close()
        return cursorcount > 0
    }
    }
*/
