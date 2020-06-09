package study

/*
* 对象与泛型
* */

fun main(args: Array<String>) {
    foo()

    //伴生对象使用
    User1.instance.printTest()
}

//如果只想建立一个对象，不继承任何类，不实现任何接口，可以这样写
private fun foo() {
    var abc = object {
        var a: Int = 1
        var b: Int = 2
    }
    println("${abc.a} ${abc.b}")
}

class User1 {
    //构造方法私有化
    private constructor()

    //匿名对象可以用作只在本地和私有作用域中声明的类型
    private fun getUserName() = object {
        val userName = "abc"
    }

    // 使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，
    // 那么该函数或属性的实际类型会是匿名对象声明的超类型，
    // 如果你没有声明任何超类型，就会是 Any
    // 在匿名对象中添加的成员将无法访问
    fun getAge() = object {
        val age = 22
    }

    fun get() {
        getUserName().userName
        //getAge().age //编译报错
    }

    var age = 22
    fun test(test: Test) {
        test.test()
    }
    fun printTest() {
        test(object : Test{
            override fun test() {
                //注意java的匿名内部类使用的变量必须是final类型的，kotlin不需要
                age =25
            }
        })
    }

    //Java中有静态类成员，而Kotlin中没有，要实现像静态类成员的功能，就要用到伴生对象。
    companion object{
        var instance = User1()

    }

//    用out来修饰T，只能消费T类型，不能返回T类型；
//    用in来修饰T，只能返回T类型，不能消费T类型。简单来说就是 in 是消费者, out 是生产者。

    class BoxOut<out T>{

    }

    // out 类似于？extends 代表上限。上限可以接受其子类的值，否则报错
    // in 类似于？super 代表下限。下限可以接受其父类的值。否则报错
    // out赋值给上限，in赋值给下限
    fun test1(strs: BoxOut<String>) {
        var objs: BoxOut<Any> = strs
    }
    fun test2(strs: BoxOut<Any>) {
        //报错
//        var objs: BoxOut<String> = strs
    }

    class BoxIn<in T> {}
    fun test3(strs: BoxIn<String>) {
        //报错
//        var objs: BoxIn<Any> = strs
    }
    fun test4(strs: BoxIn<Any>) {
        var objs: BoxIn<String> = strs
    }


}

interface Test{
    fun test()
}

