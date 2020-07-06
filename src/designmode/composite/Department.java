package designmode.composite;

public class Department extends AbsOrgnization {
    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    void print() {
        System.out.println(getName() + "  " + getDesc());
    }
}
