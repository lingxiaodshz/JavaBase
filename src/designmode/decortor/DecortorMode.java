package designmode.decortor;

public class DecortorMode {
    public static void main(String[] args) {
        new LatteCoffee().descDrink();
        new Suger(new MoccaCoffee()).descDrink();
        new Chocolate(new Suger(new LatteCoffee())).descDrink();
    }
}
