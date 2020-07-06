package designmode.composite;

/**
 * 组合模式
 */
public class CompositeMode {
    public static void main(String[] args) {
        University university = new University("蓝翔职业技术学院", "挖掘机最棒");
        College college1 = new College("挖掘机院系", "");
        College college2 = new College("厨艺院系", "");
        university.add(college1);
        university.add(college2);

        college1.add(new Department("开挖掘机专业","挖掘机好开"));
        college1.add(new Department("修挖掘机专业", "挖掘机不好修"));

        college2.add(new Department("鲁菜系专业","鲁菜好吃"));
        college2.add(new Department("川菜系专业", "川菜更好吃"));

//        college2.print();
        university.print();
    }
}
