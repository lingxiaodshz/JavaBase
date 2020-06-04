package study

/*
* 函数与Lambda表达式
* */

fun main(args: Array<String>) {
    foo("hello")
    foo("hello", 2)

    // 注意，如果不是第一个参数，必须使用i=15这样传值才可以
    foo1(i = 15)
    foo1("hello", 16)

    val a = listOf(1, 2, "b")
    println(asList(a))
    println(asList(1, 2, a, 3))

    println(foo2("hello"))

    foo3()

    println(count(12))

    println("hello world".removeLetter("h").removeLetter("o"))

    var sum:(Int)->Int={ x-> x + 1}
    println(sum(3))

    println(printName("Name:",::getName))
}

//Kotlin函数可以有默认值，如果没有传，可以直接使用默认值
fun foo(str: String, i: Int = 1) {
    println("${str} ${i}")
}

//如果有默认值的参数在无默认值的参数之前，
// 要略过有默认值的参数去给无默认值的参数指定值，要使用命名参数来指定值
fun foo1(str: String = "hello", i: Int): Unit {
    println("$str $i")
}

//函数的参数可以用 vararg 修饰符标记，表示允许将可变数量的参数传递给函数
fun <T> asList(vararg ts: T): List<T> {
    var list = mutableListOf<T>()
    for (t in ts) {
        list.add(t)
    }
    //或者
//    list.addAll(ts)
    return list
}

fun foo2(a: String) = a + 1

//Kotlin支持在函数内嵌套另一个函数，嵌套在里面的函数成为局部函数
fun foo3() {
    println("outside")
    fun inside() {
        println("inside")
    }
    //注意inside必须写在声明之后，否则会报错
    inside()
}

//当一个函数用tailrec修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本，无堆栈溢出的风险
tailrec fun count(x:Int):Int=if (x==10) x else count(x - 1)

//中缀表示法
//中缀表示法是调用函数的另一种方法。如果要使用中缀表示法，需要用infix 关键字来修饰函数，且要满足下列条件：
//它们必须是成员函数或扩展函数；
//它们必须只有一个参数；
//其参数不得接受可变数量的参数。
infix fun String.removeLetter(str: String): String {
    return replace(str, "")
}

//Lambda表达式的语法如下：
//Lambda 表达式总是括在大括号中；
//其参数（如果有的话）在 -> 之前声明（参数类型可以省略）；
//函数体（如果存在的话）在 -> 后面。
fun sum(): (Int, Int) -> Int = { x, y -> x + y }

//高阶函数是将函数用作参数或返回值的函数
fun getName(name: String) = name
fun printName(a: String, name: (str: String) -> String):String {
    var str = "$a${name("LL")}"
    return str
}
//上面代码中name: (str: String) -> String是一个函数，
//拥有函数类型() -> String，接收一个String参数，
//当我们执行var str = "$a${name("Czh")}"这行代码的时候，
//相当于执行了var str = "$a${getName("Czh")}"，并返回了字符串"Czh"。
//当我们调用printName("Name:", ::getName)时，将函数作为参数传入高阶函数，
//需要在该函数前加两个冒号::作为标记。

