package spring;

public class Address {
    private String privence;
    private String city;

    public Address() {
        System.out.println("Address init");
    }

    @Override
    public String toString() {
        return "Address{" +
                "privence='" + privence + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getPrivence() {
        return privence;
    }

    public void setPrivence(String privence) {
        this.privence = privence;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
