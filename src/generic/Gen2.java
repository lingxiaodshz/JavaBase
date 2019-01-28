package generic;

public class Gen2<T> {
    private T t;

    public Gen2(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void show(Gen2<? extends Number> gen2) {
        System.out.println(gen2.getT());
    }

}
