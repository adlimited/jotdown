package com.example.jotdown.Adapter

import android.app.Activity
import com.example.jotdown.Model.Person
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.jotdown.R
import kotlinx.android.synthetic.main.row_layout.view.*


class ListPersonAdapter(
    internal var activity: Activity,
    internal var lstPerson: List<Person>
) : BaseAdapter() {

    internal var inflater: LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return lstPerson.size
    }

    override fun getItem(p0: Int): Any {
        return lstPerson[p0]
    }

    override fun getItemId(p0: Int): Long {
        return lstPerson[p0].id.toLong()

    }


    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val rowView: View
        rowView = inflater.inflate(R.layout.row_layout, null)

        //rowView.txt_row_id.text = lstPerson[p0].id.toString()
        rowView.txt_name.text = lstPerson[p0].name.toString()
        rowView.txt_email.text = lstPerson[p0].email.toString()
        rowView.txt_sdate.text = lstPerson[p0].sdate.toString()

        /*  rowView.setOnClickListener {

              edt_id.setText(rowView.txt_row_id.text.toString())
              edt_name.setText(rowView.txt_name.text.toString())
              edt_email.setText(rowView.txt_email.text.toString())

          }

          */

        return rowView
    }


}