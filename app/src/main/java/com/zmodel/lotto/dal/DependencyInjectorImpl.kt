package com.zmodel.lotto.dal

import com.chaquo.python.Python

class DependencyInjectorImpl:DependencyInjector {
//    private var python: Python? = null

    override fun lottoRepository(): ClassicLoto {



        return ClassicLoto()
    }

    override fun callAtrr(file: String,function:String, args: Array<String>): String {

        var python = Python.getInstance()
        val pythonFile = python.getModule(file)
        val helloWorldString = pythonFile.callAttr(function,args)
        return   (helloWorldString.toString())
    }
}