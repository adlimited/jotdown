package com.example.jotdown

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jotdown.DBHelper.DBHelper
import com.example.jotdown.Model.Person
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    //DECLARE THE PASSING ITEM
    companion object{
        const val SDATE = "SDATE"
    }

    internal lateinit var db:DBHelper
    internal var lstPerson:List<Person> = ArrayList<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        db = DBHelper(this)

        val sdate = intent.getStringExtra(SDATE)
        //selectdate.text = sdate






        btn_add.setOnClickListener {
            val person = Person(0,
                edt_name.text.toString(),
                edt_email.text.toString(),
                sdate.toString()
            )

            db.addPerson(person)
            refreshData()
            startActivity(Intent(this, MainActivity::class.java))


            Toast.makeText(
                applicationContext, "Event successfully added! 😃",
                Toast.LENGTH_LONG
            ).show()


        }

     /*   btn_delete.setOnClickListener {

            Toast.makeText(
                applicationContext, "hahaha",
                Toast.LENGTH_LONG
            ).show()
        }



       btn_delete.setOnClickListener {
            val person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )

            db.deletePerson(person)
            refreshData()
        } */

    }

    private fun refreshData() {
        lstPerson = db.allPerson
    }
}