package com.zmodel.lotto.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.zmodel.lotto.R
import com.zmodel.lotto.dal.DependencyInjectorImpl
import com.zmodel.lotto.presenter.MainContract
import com.zmodel.lotto.presenter.MainPresenter


class MainActivity : AppCompatActivity(),MainContract.View {
    private lateinit var startDate: TextView
    private lateinit var endDate: TextView
    private lateinit var dateGet: Button
    internal lateinit var presenter: MainContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (! Python.isStarted()) {
            Python.start( AndroidPlatform(this));
        }
        setContentView(R.layout.activity_main)
        startDate=findViewById(R.id.startDate)
        endDate=findViewById(R.id.endtDate)


        setPresenter(MainPresenter(this, DependencyInjectorImpl(),this))
        presenter.onViewCreated(startDate,endDate,supportFragmentManager)


        var python = Python.getInstance()
        val pythonFile = python.getModule("text")
        var py_obj = pythonFile.callAttr("Lotto")
        val data = py_obj.callAttr("run")//,args)
        endDate.text = data.toString()



//        val python = Python.getInstance()
//        val pythonFile = python.getModule("text")
//        val helloWorldString = pythonFile.callAttr("helloworld","shimon")
//        endDate.text = helloWorldString.toString()

    }

    override fun displaySomteting() {
        print("d")
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

//    fun showDatePickerDialog(dateControl:TextView ) {
//        val newFragment = DatePickerFragment(this,dateControl)
//        newFragment.show(supportFragmentManager, "datePicker")
//
//    }
}