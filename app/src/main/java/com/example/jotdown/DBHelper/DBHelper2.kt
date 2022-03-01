package com.example.jotdown.DBHelper

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.jotdown.Example7Fragment
import com.example.jotdown.Model.Person


class DBHelper2 (context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER){

    internal lateinit var ex:Example7Fragment

    //private var ddate = ""

    companion object{
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "EDMTDB.db"

        val TABLE_NAME = "Person"
        private val COL_IDD = "Key"
        private val COL_ID = "Id"
        private val COL_NAME = "Name"
        private val COL_EMAIL = "Email"
        const val SDATE = "SDATE"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_NAME ($COL_IDD INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT, $COL_EMAIL TEXT, $SDATE TEXT)")

        p0!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0!!)
    }

    //CRUD

    val allPerson:List<Person>
         @SuppressLint("Range")
         get(){
             val lstPerson = ArrayList<Person> ()

             val selectQuery = "SELECT * FROM $TABLE_NAME"
             val p0 = this.writableDatabase
             val cursor = p0.rawQuery(selectQuery,null)
             if(cursor.moveToFirst()){

                 do{
                     val person = Person()
                     person.id = cursor.getInt(cursor.getColumnIndex(COL_IDD))
                     person.name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                     person.email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))
                     person.sdate = cursor.getString(cursor.getColumnIndex(SDATE))

                     lstPerson.add(person)

                 } while (cursor.moveToNext())


             }
             p0.close()
             return lstPerson

         }


}