package com.zmodel.lotto.dal

interface DependencyInjector {
    fun lottoRepository():ClassicLoto
    fun callAtrr(file: String,function:String, args: Array<String>): String

}