package designmode.adapter.interfaceadapter;

import designmode.adapter.objectadapter.Voltage5Adapter;

public class Phone {
    private AbstractVoltageAdapter adapter;

    public Phone(AbstractVoltageAdapter adapter) {
        this.adapter = adapter;
    }

    public void charging5() {
        if (adapter != null) {
            if (adapter.outputVoltage5() > 5) {
                System.out.println("电压过大");
            } else if (adapter.outputVoltage5() == 5) {
                System.out.println("电压正常，可以充电");
            }
        }
    }
}
