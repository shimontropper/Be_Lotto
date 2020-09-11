package com.zmodel.lotto.presenter

interface MainContract {
interface Presenter:BasePresenter{
    fun onViewCreated()
    fun onLoadTable()
}
    interface View:BaseView<Presenter>
    {
        fun displaySomteting()
    }
}