package com.zmodel.lotto.presenter

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.chaquo.python.Python
import com.zmodel.lotto.dal.ClassicLoto
import com.zmodel.lotto.dal.DependencyInjector
import com.zmodel.lotto.view.DatePickerFragment

class MainPresenter(val view: MainContract.View,val dependencyInjector: DependencyInjector,val activity: Context):MainContract.Presenter
{
    private val lottoRepository:ClassicLoto = dependencyInjector.lottoRepository()
    override fun onViewCreated(
        startDate: TextView,
        endDate: TextView,
        supportFragmentManager: FragmentManager
    ) {

        startDate.setOnClickListener{view: View ->showDatePickerDialog(startDate,supportFragmentManager)}
        endDate.setOnClickListener{view: View ->showDatePickerDialog(dateControl = endDate,
            supportFragmentManager = supportFragmentManager
        )}
//        "helloworld","shimon")
        var args:Array<String> = arrayOf("tropper")
        val helloWorldString = dependencyInjector.callAtrr("text","run", args = args)
        endDate.text = helloWorldString.toString()

//        var python = Python.getInstance()
//        val pythonFile = python.getModule("text")
//        val helloWorldString = pythonFile.callAttr("helloworld",args)
//        helloWorldString.toString()
//        endDate.text = helloWorldString.toString()


    }


    override fun onLoadTable() {
//        TODO("Not yet implemented")
    }
    fun showDatePickerDialog(dateControl:TextView,supportFragmentManager: FragmentManager) {
        val newFragment = DatePickerFragment(activity = activity,dateControl = dateControl)
        newFragment.show(supportFragmentManager, "datePicker")

    }
}
