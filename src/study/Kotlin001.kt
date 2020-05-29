package study

fun main(args: Array<String>) {
    println("test")
    println(sum(1, 2))
    var a: Int = 2
    val b: Int = 3
    a = sum(a, b)
    println(a)

    // 模板中的简单名称：
    val s1 = "a is $a"
    a = 8
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s1)
    println(s2)

    println(max(a, b))

//    val items = listOf("apple", "banana", "kiwifruit")
//    var index = 0
//    while (index < items.size) {
//        println("item at $index is ${items[index]}")
//        index++
//    }
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println(describ(1.0))

}

fun sum(a: Int, b: Int) = a + b

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun describ(obj: Any):String {
    var str = when (obj) {
        1 -> "One"
        is Long -> "Long"
        "Hello" -> "Hello"
        else -> "Unknown"
    }
    return str;
}


