package designmode.builder;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void build() {
        if (builder != null) {
            builder.buildBasic();
            builder.buildWall();
            builder.buildRoof();

            System.out.println(builder.getHouse());
        }
    }
}
