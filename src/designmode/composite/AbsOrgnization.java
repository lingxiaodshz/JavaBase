package designmode.composite;

public abstract class AbsOrgnization {
    private String name;
    private String desc;

    public AbsOrgnization(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void add(AbsOrgnization orgnization) {
        throw new UnsupportedOperationException();
    }

    public void remove(AbsOrgnization orgnization) {
        throw new UnsupportedOperationException();
    }

    abstract void print();
}
