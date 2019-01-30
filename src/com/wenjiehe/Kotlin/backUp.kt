package com.wenjiehe.Kotlin

import java.io.File

fun main(args: Array<String>) {
    val files = File("Test").listFiles()

    println(files?.size)

    val con = construction(1)
    var x=0
    for (x in 1..5){
        println("hello $x")
    }
    println("hello")
    val runnable = "222"
    // lambda写法1
    val runnable3 = {
        println("I'm a Lambda")
    }
    var i = 0
    i++
    Thread(runnable3).start()

    val sum: (Int, Int) -> Int = { x, y -> x + y }
    println(sum(2, 3))
}

fun temp(j: Int = 0) = 1 + j
fun sum(s: Int, w: Int) = s + w

class Apple{

}

open class Fruit{

}

class construction constructor(i: String) {
    init {
        println("$i")
    }

    constructor(i: Int) : this("a") {
        var s = "dd"
        println("$i")
    }

    constructor() : this("none") {
        print("none constructor")
    }

    //    @JvmStatic
//    fun main(args:Array<String>){
//
//    }
    object SingleTon {
        fun insert(i:Int): Boolean = i>=0

    }
}