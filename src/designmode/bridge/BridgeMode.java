package designmode.bridge;

public class BridgeMode {
    public static void main(String[] args) {
        FoldPhone foldPhone = new FoldPhone(new XiaoMi());
        foldPhone.usePhone();
        UpRightPhone upRightPhone = new UpRightPhone(new HuaWei());
        upRightPhone.usePhone();
    }
}
