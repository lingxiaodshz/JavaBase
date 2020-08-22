package designmode.proxy.dynamic;

public class User implements IBuy {
    @Override
    public void buy() {
        System.out.println("买了一本书");
    }

    @Override
    public void buy(int num) {
        System.out.println("买了" + num + "本书");
    }
}
