package spring_05;

public class Banana {
    private int id;

    public Banana() {
        System.out.println("init....");
    }

    @Override
    public String toString() {
        return "Banana{" +
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
