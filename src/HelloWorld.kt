package cn.hesheng

import java.util.*;

fun main(args: Array<String>) {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
}


fun sum(a: Int, b: Int): Int {
    var c = 5;
    return a + b + c;
}

fun print() {
    var a = 1
// simple name in template:
    val s1 = "a is $a"

    a = 2
// arbitrary expression in template:
    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s2)
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // obj 将会在这个分支中自动转换为 String 类型
        return obj.length
    }

    // obj 在类型检查分支外仍然是 Any 类型
    return null
}

fun foreachExample1() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}

fun foreachExample2() {
    val items = listOf("apple", "banana", "kiwi")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun whileExam() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

/**
 * when
 */
fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

/**
 * ranges
 */
fun rangesEx() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    //检查数值是否在范围外：
    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }

    //使用范围内迭代：
    for (x in 1..5) {
        print(x)
    }

    //或者使用步进：
    for (x in 1..10 step 2) {
        print(x)
    }
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

//collection
fun collect() {
    var items = listOf<String>("orange", "apple");

    for (item in items) {
        println(item)
    }
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }


    items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

}


fun nullCheck(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)


    if (x == null) {
        println("Wrong number format in arg1: '${arg1}'")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: '${arg2}'")
        return
    }

// x and y are automatically cast to non-nullable after null check
    println(x * y)
}