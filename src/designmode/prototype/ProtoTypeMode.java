package designmode.prototype;

public class ProtoTypeMode {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("miemie", 1, "white");
        sheep.friend = new Sheep("miemie2", 2, "black");
        Sheep sheep2 = sheep.deepClone();
        Sheep sheep3 = sheep.deepClone();

        System.out.println(sheep.friend.hashCode());
        System.out.println(sheep2.friend.hashCode());
        System.out.println(sheep3.friend.hashCode());
    }
}
