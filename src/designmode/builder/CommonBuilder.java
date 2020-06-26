package designmode.builder;

public class CommonBuilder extends Builder {
    House house = new House();

    @Override
    void buildBasic() {
        house.basic = "普通房子地基";
    }

    @Override
    void buildWall() {
        house.wall = "普通房子砌墙";
    }

    @Override
    void buildRoof() {
        house.roof = "普通房子封顶";
    }

    @Override
    House getHouse() {
        return house;
    }
}
