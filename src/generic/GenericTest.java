package generic;

import reflect.People;

public class GenericTest {
    public static void main(String[] args) {
        Gen<Double> gen1 = new Gen<>(5D);
        gen1.show(new People("XiaoWang", 20));
        System.out.println(gen1.getT());

        Gen<Integer> gen2 = new Gen<>(6);
        gen2.show(new People("Xiao Li", 25));
        System.out.println(gen2.getT());

        //由于泛型是Number类的子类，所以String不行
//        Gen<String> gen3 = new Gen<String>("");

        Gen2<Integer> gen3 = new Gen2<>(8);
        gen3.show(gen3);

        Gen2<String> gen4 = new Gen2<>("hello world");
        // 注意此处有问题，因为方法已经对泛型进行了限制
//        gen4.show(gen4);
    }
}
