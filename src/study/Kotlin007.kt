package study

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
* 扩展与委托
* */

fun main(args: Array<String>) {
    var list = mutableListOf<Int>(1, 2, 3)
    list.swap(1, 2)
    println(list)

    var list2 = mutableListOf<Char>('a', 'b', 'c')
    list2.swap(0, 2)
    println(list2)

    User2().print()

    var a: String? = "a"
    println(a.toString())

    User2.test()

    var b = ImplBase(10)
    Drived(b).print()
    Drived2(b).print()

    var user3 = User3()
    user3.name = "user3"
    println(user3.name)

    println(lazyValue)
    println(lazyValue)

    name = "abc"
    //只有赋值为hello被允许
    name1 = "hello"
    name1 = "hello1"


    var map = mapOf("name" to "wang", "age" to 22)
    var user = User5(map)
    println("${user.name}  ${user.age}")
}

//扩展函数
fun <T> MutableList<T>.swap(index1:Int,index2:Int){
    var temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}


//注意如果扩展函数和内部成员函数重名，优先使用内部成员函数
class User2 {
    // 注意如果伴生对象扩展函数和伴生对象内部成员函数重名，优先使用伴生对象内部成员函数
    companion object {
//        fun test(){
//            println("伴生对象内部成员函数")
//        }
    }

    fun print() {
        println("内部成员函数")
    }
}

fun User2.print() {
    println("扩展函数")
}

// 可空接收函数
fun Any?.toString(): String {
    return this?.toString() ?: "${this} is null"
}

//扩展伴生对象
// 注意伴生对象必须在类里面有声明才可以，否则不行
// 必须注意此处的Companion是大写，类里面的是小写
fun User2.Companion.test() {
    println("伴生对象扩展函数")
}


/*
* 类委托
* */
interface Base{
    fun print()
}

//注意如果i没有被使用的话是不需要var声明的，如果被使用了，则必须用var声明
class ImplBase(var i: Int) : Base {
    override fun print() {
        println(i)
    }
}

//定义一个 Drived 类实现接口 Base
//class Drived(var b: Base) : Base {
//    //这里需要 override 接口 Base 里的方法
//    override fun print() {
//        b.print()
//    }
//}

//如果使用委托模式的话，可以把 Base 里的方法委托给 Drived
//使用委托模式可以不用var,使用也可以，两种方式都行
class Drived(b: Base) : Base by b
//class Drived(var b: Base) : Base by b

//如果不进行委托的话，则要 override Base 接口的 print 方法。
//如果出现委托后仍然 override 的情况，编译器会使用你的 override实现取代委托对象中的实现
class Drived2(b: Base) : Base by b {
    override fun print() {
        println("abc")
    }
}


/*
* 属性委托
* */

class A {
    var name:String? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        println("getValue  类名：$thisRef, 属性名：${property.name}")
        return name
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        println("setValue  类名：$thisRef, 属性名：${property.name}，值：$value")
        name = value
    }
}

private class User3 {
    var name: String? by A()
}


/*
* 标准委托
* Kotlin标准库中提供了一些有用的委托函数：
* 延迟委托
* 可观察属性委托
* Map委托
* */

//延迟委托 延迟委托的变量不能用var修饰，提示没有setValue函数
//第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果，
// 之后再调用 get() 返回记录的结果。
//默认情况下，对于 lazy 属性的求值是同步锁的（synchronized）：
// 该值只在一个线程中计算，并且所有线程会看到相同的值。
//主要枚举LazyThreadSafetyMode{SYNCHRONIZED, PUBLICATION, NONE}
val lazyValue:String by lazy {
    println("la la la") //只会在第一次执行的时候调用，之后再使用这个变量，这个方法不会再执行
    "lazy"
}

/*
* 可观察属性委托
* 实现可观察属性委托的函数是Delegates.observable()，当我们使用该委托函数时，可以观察属性的变化
* */
//这个委托可以用来监测数据改变，只要被赋值，则能获取到之前的数据，即使newValue的值和oldValue的值相同
private var name:String by Delegates.observable("abc"){ property, oldValue, newValue ->
    println("属性名：$property  旧值：$oldValue  新值：$newValue")
}

//如果想拦截属性的赋值操作，并且否决他的赋值操作，可以用vetoable()取代 observable()，
// 传递给vetoable()的修改时处理程序会返回一个boolean类型，
// 如果返回true，允许赋值，返回false则反之。如下所示：
private var name1: String by Delegates.vetoable("abc") { property: KProperty<*>, oldValue: String, newValue: String ->
    if (newValue == "hello") {
        println("允许赋值${newValue}")
        true
    } else {
        println("禁止赋值${newValue}")
        false
    }
}

/*
* Map委托
* Map委托是指用Map实例自身作为委托来实现委托属性，通常用于解析 JSON
* */
//新建User类，主构函数要求传入一个Map
private class User5(val map: Map<String, Any>) {
    //声明一个 String 委托给 map
    val name: String by map
    //因为 Map 为只读，所以只能用 val 声明
    val age: Int     by map
}
