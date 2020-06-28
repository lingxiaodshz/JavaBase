package designmode.bridge;

public class UpRightPhone extends AbstractPhone {
    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void usePhone() {
        System.out.println("直立手机*************");
        super.usePhone();
    }
}
