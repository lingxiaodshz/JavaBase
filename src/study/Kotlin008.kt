package study

/*
* 反射和注解
* */

//Kotlin中使用反射功能所需的运行时组件作为单独的 JAR 文件（kotlin-reflect.jar）分发

fun main(args: Array<String>) {
    //在Kotlin中，用类名+两个冒号::+class（如果是java类要在后面加上.java）表示获取这个类的对象。
    //如果User是Kotlin的类
    var user1 = User4::class
    //如果User是Java的类
    var user2 = User4::class.java

    var clazz = User4::class.java
    var constructor = clazz.getConstructor(String::class.java)
    var method = clazz.getMethod("printName")
    var user = constructor.newInstance("lilei")
    method.invoke(user)

    //在Kotlin中，可以用类名+两个冒号::+函数名直接获取这个函数的对象；或者利用Java反射机制调用getMethod()方法来获取函数的对象。
    //上面是利用java反射机制，下面是kotlin的方式
    //获取printName函数对象
    var p = User4::printName
    p.invoke(user)

    var name = user.name
    println(name)
}

private data class User4(var name: String) {

    fun printName() {
        println(name)
    }
}

//java声明注解用@interface，kotlin用annotation
//java方式
//@Target(ElementType.METHOD)//表示可以在方法中使用
//@Retention(RetentionPolicy.SOURCE)//表示只存在于源码中，会被编译器忽略
//public @interface Override{
//
//}
//kotlin方式
@Target(AnnotationTarget.FUNCTION)//表示可以在函数中使用
@Retention(AnnotationRetention.RUNTIME)//表示运行时注解
private annotation class B {

}

//注解可以带有构造函数
/*
Java代码
public @interface MyAnnotation {
    int value();
}
//使用
@MyAnnotation(1)
public class Foo {
}
*/
//kotlin  注意参数不能用var定义，必须是val
private annotation class MyAnnotation(val str: String)
@MyAnnotation("test")
class Foo{
}

/*
注解类的构造函数只允许下列参数类型：
对应于 Java 原生类型的类型（Int、 Long等）；
字符串；
类（Foo::class）；
枚举；
其他注解；
上面已列类型的数组。
Kotlin中只允许用val声明参数
当参数类型是其他注解时，该注解类的名字前面不能用@
*/
