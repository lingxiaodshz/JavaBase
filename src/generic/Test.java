package generic;

public class Test {
    public static void main(String[] args) {

    }

    //定义泛型方法时，必须在返回值前边加一个<T>，来声明这是一个泛型方法，
    // 持有一个泛型T，然后才可以用泛型T作为方法的返回值。
    public<T> T getClass(T t) {
        return t;
    }

    //注意 Java规定，不能在所有的静态方法、静态初块等所有静态内容中使用泛型的类型参数
    public static<T1> T1 getA(T1 t1) {
        return t1;
    }
}

class A {

}

class B {

}
