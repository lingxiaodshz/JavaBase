package designmode.adapter.classadpeter;

public class Phone {
    private Voltage5Adapter adapter;

    public Phone(Voltage5Adapter adapter) {
        this.adapter = adapter;
    }

    public void charging() {
        if (adapter != null) {
            if (adapter.outputVoltage5() > 5) {
                System.out.println("电压过大");
            } else if (adapter.outputVoltage5() == 5) {
                System.out.println("电压正常，可以充电");
            }
        }
    }
}
