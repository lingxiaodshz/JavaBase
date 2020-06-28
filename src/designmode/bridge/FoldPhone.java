package designmode.bridge;

public class FoldPhone extends AbstractPhone {
    public FoldPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void usePhone() {
        System.out.println("折叠手机*************");
        super.usePhone();
    }
}
