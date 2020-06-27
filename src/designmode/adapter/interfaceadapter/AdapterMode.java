package designmode.adapter.interfaceadapter;

public class AdapterMode {
    public static void main(String[] args) {
        Phone phone = new Phone(new AbstractVoltageAdapter(){
            @Override
            public int outputVoltage5() {
                int output = 5;
                return output;
            }
        });
        phone.charging5();
    }
}
