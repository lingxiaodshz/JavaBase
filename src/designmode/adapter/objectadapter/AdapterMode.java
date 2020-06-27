package designmode.adapter.objectadapter;

public class AdapterMode {
    public static void main(String[] args) {
        Phone phone = new Phone(new Voltage5Adapter(new Voltage220()));
        phone.charging();
    }
}
