package designmode.adapter.classadpeter;

/**
 * 适配器模式之类适配器模式
 */
public class Voltage5Adapter extends Voltage220 {
    public int outputVoltage5() {
        int src = outputVoltage220();
        src = src / 44;
        return src;
    }
}
