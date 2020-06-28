package designmode.bridge;

public class AbstractPhone {
    private Brand brand;

    public AbstractPhone(Brand brand) {
        this.brand = brand;
    }

    public void usePhone() {
        if (brand != null) {
            brand.open();
            brand.call();
            brand.close();
        }
    }
}
