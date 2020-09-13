package com.zmodel.lotto.presenter

import android.widget.TextView
import androidx.fragment.app.FragmentManager

interface MainContract {
interface Presenter:BasePresenter{
    fun onViewCreated(
        startDate: TextView,
        endDate: TextView,
        supportFragmentManager: FragmentManager
    )
    fun onLoadTable()
}
    interface View:BaseView<Presenter>
    {
        fun displaySomteting()
    }
}