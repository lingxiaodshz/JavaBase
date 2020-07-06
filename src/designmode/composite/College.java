package designmode.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends AbsOrgnization {
    List<AbsOrgnization> list = new ArrayList<>();
    public College(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(AbsOrgnization orgnization) {
        list.add(orgnization);
    }

    @Override
    public void remove(AbsOrgnization orgnization) {
        list.remove(orgnization);
    }

    @Override
    void print() {
        System.out.println("------------" + getName() + "-------------");
        for (AbsOrgnization orgnization : list) {
            orgnization.print();
        }
    }
}
