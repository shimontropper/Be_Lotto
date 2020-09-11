package com.zmodel.lotto.view

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.zmodel.lotto.R
import java.util.*

class DatePickerFragment(val activity: Context,val dateControl:TextView) : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private lateinit var startDate: TextView
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        dateControl.setText(String.format("%s/%s/%s",day,month,year))
    }
}