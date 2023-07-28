package spring_05;

public class Grape {
    private int id;

    public Grape() {
        System.out.println("init....");
    }

    @Override
    public String toString() {
        return "Grape{" +
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
