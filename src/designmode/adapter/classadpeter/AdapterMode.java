package designmode.adapter.classadpeter;

public class AdapterMode {
    public static void main(String[] args) {
        Phone phone = new Phone(new Voltage5Adapter());
        phone.charging();
    }
}
