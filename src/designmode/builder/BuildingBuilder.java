package designmode.builder;

public class BuildingBuilder extends Builder {
    House house = new House();

    @Override
    void buildBasic() {
        house.basic = "高层建筑物地基";
    }

    @Override
    void buildWall() {
        house.wall = "高层建筑物砌墙";
    }

    @Override
    void buildRoof() {
        house.roof = "高层建筑物封顶";
    }

    @Override
    House getHouse() {
        return house;
    }
}
