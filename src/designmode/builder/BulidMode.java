package designmode.builder;

public class BulidMode {
    public static void main(String[] args) {
        CommonBuilder commonBuilder = new CommonBuilder();
        Director director = new Director(commonBuilder);
        director.build();

        director.setBuilder(new BuildingBuilder());
        director.build();
    }
}
