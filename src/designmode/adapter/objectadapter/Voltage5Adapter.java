package designmode.adapter.objectadapter;

/**
 * 适配器模式之对象适配器模式
 */
public class Voltage5Adapter {
    private Voltage220 voltage220;

    public Voltage5Adapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    public void setVoltage220(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    public int outputVoltage5() {
        int src = 0;
        if (voltage220 != null) {
            src = voltage220.outputVoltage220();
            src = src / 44;
        }
        return src;
    }
}
