package com.wenjiehe.Kotlin

import com.wenjiehe.BaseTest.JavaSE

/**
 * Created by Administrator on 2017/5/21.
 */

fun main(args:Array<String>){
    println("hello")
    val runnable = "222"
    // lambda写法1
    val runnable3 = {
        println("I'm a Lambda")
    }
    Thread(runnable3).start()

    val sum: (Int, Int) -> Int = { x, y -> x+y }
    println(sum(2,3))
}

class BaseType{
    /*companion object{
        @JvmStatic fun main(args: Array<String>) {

        }
    }*/
}
