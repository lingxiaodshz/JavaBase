package designmode.adapter.interfaceadapter;

/**
 * 适配器模式之接口适配器模式
 */
public abstract class AbstractVoltageAdapter implements IVoltage {
    @Override
    public int outputVoltage5() {
        return 0;
    }

    @Override
    public int outputVoltage9() {
        return 0;
    }

    @Override
    public int outputVoltage12() {
        return 0;
    }

    @Override
    public int outputVoltage24() {
        return 0;
    }
}
