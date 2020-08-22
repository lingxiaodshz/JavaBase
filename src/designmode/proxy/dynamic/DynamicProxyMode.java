package designmode.proxy.dynamic;

public class DynamicProxyMode {
    public static void main(String[] args) {
        IBuy buyer = (IBuy) new ProxyFactory(new User()).getInstance();
        buyer.buy();
        buyer.buy(2);
    }
}
