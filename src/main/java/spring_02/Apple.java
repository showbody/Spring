package spring_02;

public class Apple {
    private int id;

    public Apple() {
        System.out.println("init....");
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
