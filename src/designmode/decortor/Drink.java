package designmode.decortor;

public class Drink {
    private int price;
    private String desc;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void descDrink() {
        System.out.println(getDesc() + " 价格为：" + getPrice() + "元");
    }
}
