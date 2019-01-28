package generic;

public class Gen<T extends Number> {
    private T t;

    public Gen(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <E> void show(E e) {
        System.out.println(e.toString());
    }
}
