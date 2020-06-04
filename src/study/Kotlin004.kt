package study

/*
* 类和接口
* */

fun main(args: Array<String>) {

    var people = People(age = 15)
    println(people)
    var user = User()
    user.age = 18
    println(user.name + " " + user.age)

    var student = Student("xiaoming", 10)
    var teacher = Teacher("Wang")
    teacher.age = 36
    teacher.Child()
    println(teacher)
}

class People(name: String = "Jim", address: String = "tianjin", age: Int = 20) {
    private var name: String
    private var address: String
    private var age: Int

    init {
        this.name = name
        this.address = address
        this.age = age
    }

    fun getName(): String {
        return name
    }

    fun getAddress(): String {
        return address
    }

    fun getAge(): Int {
        return age
    }

    override fun toString(): String {
        return "People(name='$name', address='$address', age=$age)"
    }
}


data class User(var name: String = "Tom", var age: Int = 10) {

}

data class Student(var name: String = "Tom") {
    constructor(name: String, age: Int) : this(name) {

    }

}

//如果一个类允许被继承，则必须设置为open
open class Teacher {
    var name: String? = null
//    get()=name //注意必须写在对应的变量名下面，不过好像没什么用处
    var age: Int? = null
//    get() = age

    constructor(name: String){
        this.name = name
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    //如果允许被重写，则方法必须设置为open，否则子类不能重写
    open fun getN(): String? {
        return this.name
    }

    override fun toString(): String {
        return "Teacher(name=$name, age=$age)"
    }

    //必须得加inner，否则无法被外面使用
    //当我们用inner关键字标记嵌套类时，可以通过外部类的实例调用嵌套类。
    inner class Child{

    }
}

class YoungTeacher : Teacher, Play {
    constructor(name: String) : super(name) {

    }

    constructor(name: String, age: Int) : super(name, age) {

    }

    override fun getN(): String? {
        return super.getN()
    }

    override fun playFootball() {

    }

}

//接口中的属性和方法都是open的，不用另外加open标识
interface Play {
    fun playFootball()
    //Kotlin的接口可以有默认方法体，可以不需要重写，当然重写也可以，这点和java不同。
    fun playBaseketball(){

    }
}

//Kotlin中的可见性修饰符：
//private ——本类内部（包含其所有成员）都可见
//protected ——只在本类内部+子类中可见
//public ——能见到类声明的任何客户端都可以见到其public成员
//internal——能见到类声明的本模块内的任何客户端都可以见到其public成员



