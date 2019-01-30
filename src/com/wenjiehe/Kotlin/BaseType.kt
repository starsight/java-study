package com.wenjiehe.Kotlin

import java.util.*
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/5/21.
 */



fun support(apiVersion: Int, block: () -> Unit) {

    if (versionOrHigher(apiVersion)) {

        block()
    }
}

fun <T> support(apiVersion: Int, function: () -> T, default: () -> T): T = if (versionOrHigher(apiVersion)) function() else default()

private fun versionOrHigher(version: Int) = version > 10

val sum: (Int, Int, Int) -> Int = { x1, y, z ->
    x1 + y
}

val sum2 = { A: Int, B: Int ->
    A + B
}

class user {
    var name: String by Delegates.observable("none name") { property, oldValue, newValue ->
        println("$oldValue->$newValue")
    }
}

data class Users(var name: String, var age: Int = 10)

fun main(args: Array<String>) {
    val u1 = Users("zhansgan", 11)
    val u2 = Users("lisi", 5)
    val users = Arrays.asList(u1, u2)
    Collections.sort(users, Comparator.comparing(Users::name))
    users.filter { it.age>10 }
            .map { it.age+=10
            it
            }
            .forEach { println("${it.name} and  ${it.age}") }

    println(users)
    Thread(Runnable { print("hhh") }).start()
    println(sum2(1, 3))

    val user = user()
    user.name = "123"
    user.name = "345"
    println(user.name)

    var a: Int = 100
    //var b:Byte =a.toByte()
    val x = (1 shl 2) or 0x000FF000
    val c = arrayOfNulls<Int>(3)
    arrayOf("1", "2")
    print('A'.toInt())
    var xy: Int = when (a) {
        1 -> {
            var mm: Int = 333
            println("$mm")
            3
        }
        else -> 4
    }

    for (xyz in 1..5) {
        println("hell-$$xy-$xyz")
    }

    var b: String? = "Kotlin"
    //b = null
    if (b != null && b.length > 0) {
        print("String of length ${b.length}")
        var len = b.length
    } else {
        print("Empty string")
    }
    val listWithNulls: List<String?> = listOf("Kotlin", null)

    var person: Person = Person(2, 3)
}

class Person constructor() {
    init {
        println("fff")
    }

    constructor(parent: Person) : this() {
        println("fff2")
    }

    constructor(m: Int) : this() {
        println("fff3")
    }

    constructor(m: Int, n: Int) : this(m) {
        println("fff4")
    }
}

open class Father constructor(str: String) {
    constructor(i: Int) : this("") {

    }
}

class Son : Father(0) {

}

open class A(str: String) {
    constructor() : this("") {

    }

    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } // 接口成员默认就是“open”的

    fun b() {
        print("b")
    }
}

class C : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调用 A.f()
        super<B>.f() // 调用 B.f()
    }

    inner class inner {
        fun a() {
            f()
        }
    }

}

object singelTon {
    fun getSingleTonInstance() {

    }
}



