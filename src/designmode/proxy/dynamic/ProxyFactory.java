package designmode.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private IBuy buyer;

    public ProxyFactory(IBuy buyer) {
        this.buyer = buyer;
    }

    public Object getInstance() {
        return  Proxy.newProxyInstance(buyer.getClass().getClassLoader(),
                buyer.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object obj = method.invoke(buyer, args);
                        return obj;
                    }
                });
    }
}
