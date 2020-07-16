package designmode.decortor;

public class Suger extends Decortor {
    public Suger(Drink drink) {
        super(drink);
        setPrice(drink.getPrice() + 2);
        setDesc(drink.getDesc()+",添加了1份糖");
    }
}
