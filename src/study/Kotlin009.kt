package study

import java.lang.Exception

/*
* Kotlin的其他技术
* */

fun main(args: Array<String>) {
    //解构声明使用,注意使用时必须是data class，会自动为我们重写equals/hashCoade,toString,compoentN,copy等方法
    var user = User6("xiaoming", 20)
    var (a, b) = user
    println("a:${a} b:$b")

    //区间
    range()

    //类型检查与转换
    typeSwitch()

    //this表达式
    testThis()

    //相等性
    testEqual()

    //运算符重载
    println(Operator(1) + Operator(2))

    //空安全
    testNull()

}

/*
* 解构声明:能同时创建多个变量，将对象中的数据解析成相对的变量
* */

private data class User6(var name:String, var age:Int)

/*
* 区间
* */
fun range() {
    //输出5,4,3,2,1
    for (i in 5 downTo 1) {
        print("$i ")
    }
    println()
    //输出1,2,3,4
    for (i in 1 until 5) {
        print("$i ")
    }
    println()
    //修改步长用step
    for (i in 1 until 5 step 2) {
        print("$i ")
    }
    println()
}

/*
* 类型检查与转换
* */
fun typeSwitch() {
    //通过is操作符判断一个对象与指定的类型是否一致,功能类似于java中的instanceOf
    println("" is String)
    println("" !is String)

    //在Kotlin中不必使用显式类型转换操作，
    // 因为编译器会跟踪不可变值的is检查以及显式转换，
    // 并在需要时自动插入（安全的）转换

    var a = ""
    if (a is String) {
        println(a.length)
    }

//    var c = when(a){
//        is String -> a.length
//        is Int -> a + 1
//        else -> 1
//    }

    //强制类型转换
    var b = "5"
    //String不能强转整型，会报类型转换异常
    //var c: Int = b as Int
    var c: Int = b.toInt()
    println(c)

    //可空转操作符 as?
    var str = null
    //如果使用as的话会抛出异常，提示使用非空变量
    //使用安全转换操作符as?可以在转换失败时返回null，避免了抛出异常。
    var str2 = str as? String
    println(str2)
}

/*
* //this表达式
* */

fun testThis() {
    //当this在类的成员中，this指的是该类的当前对象;
    // 当this在扩展函数或者带接收者的函数字面值中，this表示在点左侧传递的接收者参数
    //限定的this，如果this没有限定符，指的是最内层包含他的作用域。
    //如果要访问来自外作用域的this，使用this@label，label是外作用域的标签
    Outer().Inner().test()
}

private class Outer {

    inner class Inner{
        var a = this@Inner
        var b = this@Outer

        fun print() {
            println("Inner")
        }

        fun test() {
            a.print()
            b.print()
        }
    }

    fun print() {
        println("Outer")
    }
}


/*
* 相等性 在Kotlin中存在结构相等和引用相等两中相等判断。
* */
fun testEqual() {
    //结构相等 使用equals()或==判断
    var a = "1"
    var b = "1"
    if (a.equals(b)) {
        println("a 和 b 结构相等")
    }
    if (a == b) {
        println("a 和 b 结构相等")
    }

    //引用相等 指两个引用指向同一对象，使用===判断
    var user1 = User6("xiaoming", 12)
    var user2 = User6("xiaoming", 12)
    var user3 = user1
    var user4 = user2
    //注意此处相等是因为用data class定义的，它会重写equals和hashcode方法，对==判断造成了影响
    if (user3 == user4) {
        println("user3和user4结构相等")
    } else {
        println("user3和user4结构不相等")
    }
    if (user3 === user4) {
        println("user3和user4引用相等")
    } else {
        println("user3和user4引用不相等")
    }

}

/*
* 操作符重载
1.一元操作符
表达式	对应的函数
+a	a.unaryPlus()
-a	a.unaryMinus()
!a	a.not()
a++	a.inc()
a--	a.dec()
2.二元操作符
表达式	对应的函数
a+b	a.plus(b)
a-b	a.minus(b)
a*b	a.times(b)
a/b	a.div(b)
a%b	a.mod(b)
a..b	a.rangeTo(b)
3.in操作符
表达式	对应的函数
a in b	b.contains(a)
a !in b	!b.contains(a)
4.索引访问操作符
表达式	对应的函数
a[i]	a.get(i)
a[i, j]	a.get(i, j)
a[i_1, ……, i_n]	a.get(i_1, ……, i_n)
a[i] = b	a.set(i, b)
a[i, j] = b	a.set(i, j, b)
a[i_1, ……, i_n] = b	a.set(i_1, ……, i_n, b)
5.调用操作符
表达式	对应的函数
a()	a.invoke()
a(i)	a.invoke(i)
a(i, j)	a.invoke(i, j)
a(i_1, ……, i_n)	a.invoke(i_1, ……, i_n)
6.广义赋值
表达式	对应的函数
a += b	a.plusAssign(b)
a -= b	a.minusAssign(b)
a *= b	a.timesAssign(b)
a /= b	a.divAssign(b)
a %= b	a.remAssign(b), a.modAssign(b)（已弃用）
7.相等与不等操作符
表达式	对应的函数
a == b	a?.equals(b) ?: (b === null)
a != b	!(a?.equals(b) ?: (b === null))
8.比较操作符
表达式	对应的函数
a > b	a.compareTo(b) > 0
a < b	a.compareTo(b) < 0
a >= b	a.compareTo(b) >= 0
a <= b	a.compareTo(b) <= 0
* */
data class Operator(var a: Int){
    operator fun plus(operator: Operator): Operator {
        a += operator.a
        return this
    }
}

/*
* 空安全
* */
fun testNull() {
    //可空类型与非空类型
    var a: String? = ""
    a = null

    //安全调用操作符
//    println(a?.length)
    println(a?.let { a.length })

    //安全类型操作符
    val i: Int? = "" as? Int

    //可空类型集合
    val nullableList: List<Int?> = listOf(1, null, 2)
    val intList = nullableList.filterNotNull().filter { it > 1 }
    println(intList)

}

/*
* 异常
* */
fun testException() {
//    Kotlin中所有异常类都是Throwable类的子类。每个异常都有消息、堆栈回溯信息和可选的原因。
//    使用throw表达式可以抛出异常。
//    使用try表达式可以捕获异常。一个try表达式可以有多个catch代码段；finally代码段可以省略
    try {
        //捕获异常
    } catch (e: NullPointerException) {
        //异常处理
    } catch (e: ClassNotFoundException) {
        //异常处理
    } finally {
        //可选的finally代码段
    }

    //try是一个表达式，所以它可以有一个返回值
    //try表达式的返回值是 try块中的最后一个表达式或者是catch块中的最后一个表达式。
    // finally块中的内容不会影响表达式的结果
    var a: Int = try {
        2
    } catch (e: Exception) {
        1
    }

}











