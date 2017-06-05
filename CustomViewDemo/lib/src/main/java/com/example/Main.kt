package com.example

/**
 * Created by OldFour on 2017/6/1.
 */

fun main(args: Array<String>){
    println("hello kotlin")
    Person("刘浩").printName()

    var quantity =5
    val price:Double =20.3
    val name:String ="大米"



    println(quantity);
    println(price);
    println(name);

    if (quantity in 4..6){
        println("大于四小于五")
    }


}
