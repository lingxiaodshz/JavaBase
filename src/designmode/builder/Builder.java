package designmode.builder;

public abstract class Builder {

    abstract void buildBasic();

    abstract void buildWall();

    abstract void buildRoof();

    abstract House getHouse();

}
