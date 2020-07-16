package designmode.decortor;

public class Chocolate extends Decortor {
    public Chocolate(Drink drink) {
        super(drink);
        setPrice(drink.getPrice() + 3);
        setDesc(drink.getDesc() + ",添加了1份巧克力");
    }
}
