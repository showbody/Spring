package spring_03;

public class Pear {
    private int id;

    public Pear() {
        System.out.println("init....");
    }

    @Override
    public String toString() {
        return "Pear{" +
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
