package com.zmodel.lotto.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.zmodel.lotto.R


class MainActivity : AppCompatActivity() {
    private lateinit var startDate: TextView
    private lateinit var endDate: TextView
    private lateinit var dateGet: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startDate=findViewById(R.id.startDate)
        endDate=findViewById(R.id.endtDate)


        startDate.setOnClickListener{view:View->showDatePickerDialog(startDate)}
        endDate.setOnClickListener{view:View->showDatePickerDialog(endDate)}

    }
    fun showDatePickerDialog(dateControl:TextView ) {
        val newFragment = DatePickerFragment(this,dateControl)
        newFragment.show(supportFragmentManager, "datePicker")

    }
}