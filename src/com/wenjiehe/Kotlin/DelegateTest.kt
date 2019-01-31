package com.wenjiehe.Kotlin

import kotlin.reflect.KProperty

val data = arrayOf<MutableMap<String, Any?>>(
        mutableMapOf(
                "id" to 1,
                "name" to "Tony",
                "password" to "123456"
        ),
        mutableMapOf(
                "id" to 2,
                "name" to "Monica",
                "password" to "123456"
        )
)

fun main(args:Array<String>){
    var bb : Base = baseImp(10)
    var bb2 : Base = baseImp(10)

    Delegate(bb).print()

    val u = User1()
    u.na ="123"
    println(u.na)


}


interface Base{
    fun print()
}

class baseImp(var i:Int) : Base{

    override fun print() {
        println("BaseImplement $i")
    }

    operator  fun plusAssign(baseImp: baseImp){
       i+= baseImp.i
    }
}

class Delegate(b :Base) :Base by b




class User1{
    var na :String by Dele()
}

class Dele{
    operator fun getValue(user: User1, property: KProperty<*>): String {

        return "$user,getValue: ${property.name}"
    }

    operator fun setValue(user: User1, property: KProperty<*>, s: String) {
        //user.na =s
        println(s)
    }

}