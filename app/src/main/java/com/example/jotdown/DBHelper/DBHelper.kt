package com.example.jotdown.DBHelper

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.jotdown.Example7Fragment
import com.example.jotdown.Model.Date
import com.example.jotdown.Model.Person


class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    internal lateinit var ex: Example7Fragment

    //private var ddate = ""

    companion object {
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
        val CREATE_TABLE_QUERY =
            ("CREATE TABLE $TABLE_NAME ($COL_IDD INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT, $COL_EMAIL TEXT, $SDATE TEXT)")

        p0!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0!!)
    }

    //CRUD

    fun passdate(date: Date) {

        //ddate = date.date.toString()

    }


    val allPerson: List<Person>
        @SuppressLint("Range")
        get() {

            val lstPerson = ArrayList<Person>()
            ex = Example7Fragment()
            val ddate = ex.selectedDate


            val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $SDATE ='$ddate'"
            val p0 = this.writableDatabase
            val cursor = p0.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {

                do {
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


    fun addPerson(person: Person) {

        val p0 = this.writableDatabase
        val values = ContentValues()
        //values.put(COL_ID,person.id)
        values.put(COL_NAME, person.name)
        values.put(COL_EMAIL, person.email)
        values.put(SDATE, person.sdate)

        p0.insert(TABLE_NAME, null, values)
        p0.close()

    }

    /* fun updatePerson(person: Person):Int {

         val p0 = this.writableDatabase
         val values = ContentValues()
         values.put(COL_ID,person.id)
         values.put(COL_NAME,person.name)
         values.put(COL_EMAIL,person.email)

         return p0.update(TABLE_NAME,values, "$COL_ID=?", arrayOf(person.id.toString()))

     }

     */

    /* fun deletePerson(person: Person) {

         val p0 = this.writableDatabase
         p0.delete(TABLE_NAME,"$COL_ID=?", arrayOf(person.id.toString()))
         p0.close()

     }

     */


}